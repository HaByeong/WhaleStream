package com.project.whalestream.login.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

import javax.crypto.SecretKey;
import java.util.Date;
import static com.project.whalestream.login.constant.Constant.ACCESS_TOKEN_TIME;

@RequiredArgsConstructor
public class JwtTokenProvider {

    private final SecretKey secretKey;

    public String generateToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .claim("role", "user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() +  ACCESS_TOKEN_TIME))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    //userId를 추출
    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();

    }
}
