package com.kramar.purplist.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JwtUtil {

    // For demo purposes use a static key. In production load from secure config
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long VALIDITY_MS = 1000L * 60 * 60 * 24; // 24h

    public String generateToken(String username) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + VALIDITY_MS);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (JwtException ex){
            return null;
        }
    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException ex){
            return false;
        }
    }

}
