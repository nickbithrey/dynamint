package org.innovation.dynamint.compconfig;

import java.util.Arrays;

import org.innovation.dynamint.MWEntityLoader;
import org.innovation.dynamint.MWStartup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Profile(MWStartup.MW_PROFILE)
public class ComponentConfigurationModelWorldLoader implements MWEntityLoader {

    static final int PRIORITY = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentConfigurationModelWorldLoader.class);

    private ComponentConfigurationRepository componentConfigurationRepo;

    public ComponentConfigurationModelWorldLoader(ComponentConfigurationRepository componentConfigurationRepo) {
        super();
        this.componentConfigurationRepo = componentConfigurationRepo;
    }

    @Override
    public double priority() {
        return PRIORITY;
    }

    @Override
    public void notifyStart() {
        LOGGER.info("Creating Component Configuration Model World");
    }

    @Override
    public void notifyFinish() {
        LOGGER.info("Created Component Configuration Model World");
    }

    @Override
    @Transactional(readOnly = false)
    public boolean load() {
        createComponentConfig("FILE_TRANSFER", "component for location of a file source or destination", "file",
                new ComponentConfigurationAttribute("location", String.class, true),
                new ComponentConfigurationAttribute("delay", Long.class, "60000", false));

        createComponentConfig("FTP_TRANSFER", "component for location of a file source or destination on an ftp server",
                "ftp", new ComponentConfigurationAttribute("location", String.class, true),
                new ComponentConfigurationAttribute("delay", Long.class, "60000", false));

        return true;
    }

    private void createComponentConfig(String reference, String description, String componentType,
            ComponentConfigurationAttribute... attributes) {
        ComponentConfiguration comp = new ComponentConfiguration();
        comp.setReference(reference);
        comp.setDescription(description);
        comp.setComponentType(componentType);
        if (attributes != null) {
            Arrays.stream(attributes).forEach(comp::addAttribute);
        }
        componentConfigurationRepo.save(comp);
    }

}
