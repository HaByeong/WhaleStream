package com.project.whalestream.login.service;

import com.project.whalestream.login.dto.UserLoginRequestDto;
import com.project.whalestream.login.dto.UserLoginResponseDto;

public interface UserLoginServiceInterface {
    UserLoginResponseDto login(UserLoginRequestDto userLoginRequestDto);
}
