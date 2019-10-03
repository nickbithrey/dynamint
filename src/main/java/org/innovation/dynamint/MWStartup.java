package org.innovation.dynamint;

import java.util.SortedSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

@org.springframework.stereotype.Component
@Profile(MWStartup.MW_PROFILE)
public class MWStartup implements CommandLineRunner {

    public static final String MW_PROFILE = "mw";

    private static final Logger LOGGER = LoggerFactory.getLogger(MWStartup.class);

    private final SortedSet<MWEntityLoader> mwEntityLoaders;

    public MWStartup(SortedSet<MWEntityLoader> mwEntityLoaders) {
        super();
        this.mwEntityLoaders = mwEntityLoaders;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Starting Model World Loading");
        long loaders = mwEntityLoaders.stream().peek(MWEntityLoader::notifyStart).peek(MWEntityLoader::load)
                .peek(MWEntityLoader::notifyFinish).count();
        LOGGER.info("Finished Model World Loading using {} loaders", loaders);
    }

}
