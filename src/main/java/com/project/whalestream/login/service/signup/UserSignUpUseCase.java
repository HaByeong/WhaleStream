package com.project.whalestream.login.service.signup;

import com.project.whalestream.login.dto.signup.UserSignUpRequestDto;

public interface UserSignUpUseCase {
    void newUser(UserSignUpRequestDto userSignUpRequestDto);
}
