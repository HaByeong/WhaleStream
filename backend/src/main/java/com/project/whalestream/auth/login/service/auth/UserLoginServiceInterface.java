package com.project.whalestream.login.service.auth;

import com.project.whalestream.login.dto.auth.UserLoginRequestDto;
import com.project.whalestream.login.dto.auth.UserLoginResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserLoginServiceInterface {
    ResponseEntity login(UserLoginRequestDto userLoginRequestDto);
}
