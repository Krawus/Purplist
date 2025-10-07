package com.kramar.purplist.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtUtil, jdbcTemplate);

        http
        .authorizeHttpRequests(authorize -> 
            authorize
                .requestMatchers("/api/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/login").permitAll()
                .requestMatchers("/api/auth/**").permitAll()
                // static resources
                .requestMatchers("/css/**", "/js/**", "/images/**", "/static/**", "/favicon.ico").permitAll()
                .anyRequest().authenticated()
        )
        // disable form login (we provide REST login)
        .formLogin(form -> form.disable())
        .exceptionHandling(configurer -> 
            configurer.accessDeniedPage("/access-denied"))

        .logout((logout) -> 
            logout.logoutUrl("/logout")
                            .permitAll())
        .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf(csrf -> csrf.disable())
        ;

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}