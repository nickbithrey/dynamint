package org.innovation.dynamint.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile("!sso")
public class WebSecurityNonSSOConfig extends WebSecurityConfigurerAdapter {

    private static final String PROFILE = "sso";

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityNonSSOConfig.class);

    public WebSecurityNonSSOConfig() {
        LOGGER.warn("Initializing in unsecured mode as profile '{}' is not enabled", PROFILE);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**");
    }

}
