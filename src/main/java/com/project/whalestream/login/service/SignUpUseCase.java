package com.project.whalestream.login.service;

import com.project.whalestream.login.dto.SignUpRequestDto;

public interface SignUpUseCase {
    void newUser(SignUpRequestDto signUpRequestDto);
}
