package org.innovation.dynamint.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(SSOConfig.PROFILE)
@EnableOAuth2Sso
public class SSOConfig {

    static final String PROFILE = "sso";

    private static final Logger LOGGER = LoggerFactory.getLogger(SSOConfig.class);

    public SSOConfig() {
        logSetup();
    }

    private void logSetup() {
        LOGGER.info("Running in secured mode");
    }

}