package com.project.whalestream.login.service;

import com.project.whalestream.login.dto.LoginRequestDto;
import com.project.whalestream.login.dto.LoginResponseDto;

public interface LoginServiceInterface {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
