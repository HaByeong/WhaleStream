package com.project.whalestream.login.dto.auth;

import lombok.Data;

//로그인 DTO

@Data
public class UserLoginRequestDto {
    private String userId;
    private String password;
}
