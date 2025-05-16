package com.project.whalestream.login.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

import javax.crypto.SecretKey;
import java.util.Date;
import static com.project.whalestream.login.constant.Constant.ACCESS_TOKEN_TIME;
import static com.project.whalestream.login.constant.Constant.REFRESH_TOKEN_TIME;

@RequiredArgsConstructor
public class JwtTokenProvider {

    private final SecretKey secretKey;

    public String generateAccessToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .claim("role", "user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_TIME))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateRefreshToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_TIME))
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
