package com.kramar.purplist.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        .dataSource(dataSource)
        .usersByUsernameQuery("select username, password, enabled "
        + "from users "
        + "where username = ?")
        .authoritiesByUsernameQuery("select username, authority "
        + "from authorities "
        + "where username = ?");
}

    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
        .authorizeHttpRequests(authorize -> 
            authorize
                .requestMatchers("/api/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        )
        .formLogin(form -> form.loginPage("/login")
                                .permitAll())
                                
        .exceptionHandling(configurer -> 
            configurer.accessDeniedPage("/access-denied"))

        .logout((logout) -> 
            logout.logoutUrl("/logout")
                            .permitAll())
                            
        .csrf(csrf -> csrf.disable());

        return http.build();
    }
}