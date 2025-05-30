package com.project.whalestream.login.dto.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseCookie;

//로그인 응답 DTO
@Getter
@AllArgsConstructor
public class UserLoginResponseDto {
    private String userId;
    //로그인 성공 시 클라이언트에게 제공하는 토큰(accessToken)
    private String accessToken;
    /*//RefreshToken을 담은
    private ResponseCookie responseCookie; -> 쿠키는!! dto로 전달하지 않는다.
    *//* accessToken 만료 시!! 재발급을 위해 필요한 토큰을 쿠키로 전달
     */
}
