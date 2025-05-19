package com.project.whalestream.login.service;

import com.project.whalestream.login.dto.UserSignUpRequestDto;

public interface UserSignUpUseCase {
    void newUser(UserSignUpRequestDto userSignUpRequestDto);
}
