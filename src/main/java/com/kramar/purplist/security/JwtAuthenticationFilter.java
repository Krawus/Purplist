package com.kramar.purplist.security;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final JdbcTemplate jdbcTemplate;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, JdbcTemplate jdbcTemplate){
        this.jwtUtil = jwtUtil;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (StringUtils.hasText(header) && header.startsWith("Bearer ")){
            String token = header.substring(7);
            if (jwtUtil.validateToken(token)){
                String username = jwtUtil.extractUsername(token);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                    List<String> auths = jdbcTemplate.queryForList("select authority from authorities where username = ?", String.class, username);
                    List<SimpleGrantedAuthority> granted = auths.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, granted);
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
