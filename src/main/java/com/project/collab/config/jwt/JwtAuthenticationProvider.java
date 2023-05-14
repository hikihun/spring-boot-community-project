package com.project.collab.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;

public class JwtAuthenticationProvider {

    @Value("${jwt.secretkey}")
    private String secretKey;
    private long tokenValidTime = 1000L * 60 * 30;

    public String createToken(String userPk, Long id) {
        Claims claims = Jwts.claims().setSubject(userPk).setId(id.toString());
        Date now = new Date();
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(new Date(now.getTime() + tokenValidTime))
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

}
