package org.innovation.dynamint.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(authClientRegistration());
    }

    private ClientRegistration authClientRegistration() {
        return ClientRegistration.withRegistrationId("auth-server").clientId("admin").clientSecret("secret")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}").scope("read", "write")
                .authorizationUri("http://localhost:8080/oauth/authorize").tokenUri("http://localhost:8080/oauth/token")
                .userInfoUri("http://localhost:8080/api/v1/user").userNameAttributeName("name")
                .clientName("Innovation Auth Server").build();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.csrf().disable()
        .authorizeRequests()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated()
        .and()
            .oauth2Login()
            .defaultSuccessUrl("/")
            .failureUrl("/error")
        .and()
            .logout();
        // @formatter:on
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**");
    }

}
