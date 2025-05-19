package com.project.whalestream.login.service.auth;

import com.project.whalestream.login.dto.auth.UserLoginRequestDto;
import com.project.whalestream.login.dto.auth.UserLoginResponseDto;

public interface UserLoginServiceInterface {
    UserLoginResponseDto login(UserLoginRequestDto userLoginRequestDto);
}
