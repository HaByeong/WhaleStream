package com.project.whalestream.login.service.signup;

import com.project.whalestream.login.dto.signup.UserSignUpRequestDto;

public interface UserSignUpServiceInterface {
    void newUser(UserSignUpRequestDto userSignUpRequestDto);
}
