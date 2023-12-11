package com.benmeehan111.ebayclone.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class APISecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jUserDetailsManager.setUsersByUsernameQuery("SELECT Username, Password, Active FROM User WHERE Username = ?;");

        jUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT Username, Role FROM User WHERE Username = ?;");

        return jUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http.authorizeHttpRequests(
        // configurer -> configurer.requestMatchers(HttpMethod.GET,
        // "/products/info/BID")
        // .hasRole("ADMIN"));

        // Allow all for testing/dev

        // http.authorizeHttpRequests(configurer ->
        // configurer.anyRequest().permitAll());

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
