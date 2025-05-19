package com.project.whalestream.login.service;

import com.project.whalestream.login.dto.UserInfoRequestDto;
import com.project.whalestream.login.dto.UserInfoUpdateRequestDto;

public interface UserInfoServiceInterface {
    void saveUserInfo(UserInfoRequestDto userInfoRequestDto);
    void updateUserInfo(UserInfoUpdateRequestDto userInfoUpdateRequestDto);
}
