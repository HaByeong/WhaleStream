package com.project.whalestream.login.config;

import com.project.whalestream.login.security.JwtAuthenticationFilter;
import com.project.whalestream.login.security.JwtTokenProvider;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtTokenProvider jwtTokenProvider) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        //requestMatchers() -> 특정 URL 경로를 지정
                        //.permitAll() -> 해당 경로는 인증 불필요
                        .requestMatchers("/ai/signup", "/ai/login").permitAll()
                        // 다른 요청들은 .authenticated()로 전부 인증이 필요하다
                        .anyRequest().authenticated()
                )
                // 이 아래 부분은 내가 만든 커스텀 필터를 기존 필터 체인에 끼워 넣는 부분이다.
                .addFilterBefore(
                        new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class
                );
        return http.build();
    }

    @Bean
    public SecretKey secretKey() {
        //시크릿 키를 application.yml로 따로 분리
        return Keys.hmacShaKeyFor("your-256-bit-secret-your-256-bit-secret".getBytes());
    }

    @Bean
    public JwtTokenProvider jwtTokenProvider(SecretKey secretKey) {
        return new JwtTokenProvider(secretKey);
    }
}
