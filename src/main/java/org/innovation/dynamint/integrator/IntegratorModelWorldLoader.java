package org.innovation.dynamint.integrator;

import org.innovation.dynamint.MWEntityLoader;
import org.innovation.dynamint.MWStartup;
import org.innovation.dynamint.compconfig.ComponentConfiguration;
import org.innovation.dynamint.compconfig.ComponentConfigurationAttribute;
import org.innovation.dynamint.compconfig.ComponentConfigurationRepository;
import org.innovation.dynamint.integrator.component.AttributeUtils;
import org.innovation.dynamint.integrator.component.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Component
@Profile({ MWStartup.MW_PROFILE, "create-mw-routes" })
public class IntegratorModelWorldLoader implements MWEntityLoader {

    static final int PRIORITY = 100;

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegratorModelWorldLoader.class);

    private final ComponentConfigurationRepository componentConfigurationRepo;

    private final IntegratorRepository integratorRepo;

    public IntegratorModelWorldLoader(ComponentConfigurationRepository componentConfigurationRepo,
            IntegratorRepository integratorRepo) {
        this.componentConfigurationRepo = componentConfigurationRepo;
        this.integratorRepo = integratorRepo;
    }

    @Override
    public double priority() {
        return PRIORITY;
    }

    @Override
    public void notifyStart() {
        LOGGER.info("Creating Integrators Model World");
    }

    @Override
    public void notifyFinish() {
        LOGGER.info("Created Integrators Model World");
    }

    @Override
    @Transactional(readOnly = false)
    public boolean load() {
        Integrator i = new Integrator("MW_FILE_TRANSFER_ROUTE", "Route that transfers a file from 1 place to another",
                IntegratorStatus.ACTIVE);
        i.setRunningStatus(IntegratorRunningStatus.RUNNING);
        Pipeline fromP = new Pipeline();
        ComponentConfiguration fileModelComp = componentConfigurationRepo.findByReference("FILE_TRANSFER")
                .orElseThrow(() -> new IllegalStateException("cannot find file component"));

        findConfigAttribute(fileModelComp, "location");
        findConfigAttribute(fileModelComp, "delay");

        Component fromComp = new Component("fromComp", "picks up MW file", fileModelComp, fromP);
        ComponentConfigurationAttribute locA = findConfigAttribute(fileModelComp, "location");
        ComponentConfigurationAttribute delayA = findConfigAttribute(fileModelComp, "delay");
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

        return true;
    }

    private ComponentConfigurationAttribute findConfigAttribute(ComponentConfiguration comp, String attributeName) {
        return comp.getAttributes().stream().filter(a -> attributeName.equals(a.getName())).findFirst().orElseThrow(
                () -> new IllegalStateException("file component doesnt have " + attributeName + " attribute"));
    }

}
