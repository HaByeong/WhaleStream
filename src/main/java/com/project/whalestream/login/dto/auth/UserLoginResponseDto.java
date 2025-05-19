package com.project.whalestream.login.dto.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

//로그인 응답 DTO
@Getter
@AllArgsConstructor
public class UserLoginResponseDto {
    private String userId;
    //로그인 성공 시 클라이언트에게 제공하는 토큰(accessToken)
    private String accessToken;
    @JsonIgnore
    private String refreshToken;
    /* accessToken 만료 시!! 재발급을 위해 필요한 토큰
    이 부분은 LoginResponseDto 여기에 넣지말고, 나중에 다루자
    private String refreshToken;
     */
}
