package com.kramar.purplist.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private DataSource dataSource;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
        .dataSource(dataSource);
}
    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
        .authorizeHttpRequests(authorize -> 
            authorize
                .requestMatchers("/api/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());
        
        return http.build();
    }
}