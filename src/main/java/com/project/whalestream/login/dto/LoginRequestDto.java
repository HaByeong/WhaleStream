package com.project.whalestream.login.dto;

import lombok.Data;

//로그인 DTO

@Data
public class LoginRequestDto {
    private String userId;
    private String password;
}
