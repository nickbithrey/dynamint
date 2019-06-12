package org.innovation.dynamint;

import org.innovation.dynamint.channel.AttributeUtils;
import org.innovation.dynamint.channel.Component;
import org.innovation.dynamint.channel.Integrator;
import org.innovation.dynamint.channel.IntegratorRepository;
import org.innovation.dynamint.channel.ModelAttribute;
import org.innovation.dynamint.channel.ModelComponent;
import org.innovation.dynamint.channel.ModelComponentRepository;
import org.innovation.dynamint.channel.Pipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

@org.springframework.stereotype.Component
public class MWStartup implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MWStartup.class);

    private final ModelComponentRepository modelComponentRepo;

    private final IntegratorRepository integratorRepo;

    public MWStartup(ModelComponentRepository modelComponentRepo, IntegratorRepository integratorRepo) {
        super();
        this.modelComponentRepo = modelComponentRepo;
        this.integratorRepo = integratorRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Creating Model World");
        ModelComponent fileComponent = new ModelComponent();
        fileComponent.setReference("file");
        fileComponent.setDescription("component for location of a file source or destination");
        fileComponent.addAttribute(new ModelAttribute("location", String.class, true));
        fileComponent.addAttribute(new ModelAttribute("delay", Long.class, false));
        modelComponentRepo.save(fileComponent);

        ModelComponent ftpComponent = new ModelComponent();
        ftpComponent.setReference("ftp");
        ftpComponent.setDescription("component for location of a file source or destination on an ftp server");
        ftpComponent.addAttribute(new ModelAttribute("location", String.class, true));
        ftpComponent.addAttribute(new ModelAttribute("delay", Long.class, false));
        modelComponentRepo.save(ftpComponent);

        createRoute();
        LOGGER.info("Created Model World");
    }

    private void createRoute() {
        Integrator i = new Integrator();
        i.setReference("model world route");
        Pipeline fromP = new Pipeline();
        ModelComponent fileModelComp = modelComponentRepo.findByReference("file")
                .orElseThrow(() -> new IllegalStateException("cannot find file component"));
        Component fromComp = new Component("fromComp", "picks up MW file", fileModelComp, fromP);
        ModelAttribute locA = fileModelComp.getAttributes().stream().filter(a -> "location".equals(a.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("file component doesnt have location attribute"));
        ModelAttribute delayA = fileModelComp.getAttributes().stream().filter(a -> "delay".equals(a.getName()))
                .findFirst().orElseThrow(() -> new IllegalStateException("file component doesnt have delay attribute"));
        fromComp.addAttribute(
                AttributeUtils.createAttr(fromComp, locA, "C:/Users/nick.bithrey/Documents/ESB-testing/dynamint"));
        fromComp.addAttribute(AttributeUtils.createAttr(fromComp, delayA, 5000l));
        fromP.setComponent(fromComp);
        i.setPipeline(fromP);

        Pipeline toP = new Pipeline();
        Component toComp = new Component("toComp", "sends the MW file", fileModelComp, toP);
        toComp.addAttribute(
                AttributeUtils.createAttr(toComp, locA, "C:/Users/nick.bithrey/Documents/ESB-testing/dynamint/done"));
        toP.setComponent(toComp);
        fromP.setNext(toP);

        integratorRepo.save(i);
    }
}
