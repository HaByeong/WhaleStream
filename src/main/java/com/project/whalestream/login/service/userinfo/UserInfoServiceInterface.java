package com.project.whalestream.login.service.userinfo;

import com.project.whalestream.login.dto.userinfo.UserInfoRequestDto;
import com.project.whalestream.login.dto.userinfo.UserInfoUpdateRequestDto;

public interface UserInfoServiceInterface {
    void saveUserInfo(UserInfoRequestDto userInfoRequestDto);
    void updateUserInfo(UserInfoUpdateRequestDto userInfoUpdateRequestDto);
}
