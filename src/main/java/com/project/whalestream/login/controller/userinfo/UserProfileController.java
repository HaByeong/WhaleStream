package com.project.whalestream.login.controller.userinfo;

import com.project.whalestream.login.dto.userinfo.UserInfoRequestDto;
import com.project.whalestream.login.dto.userinfo.UserInfoUpdateRequestDto;
import com.project.whalestream.login.service.userinfo.UserInfoServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserProfileController {

    private final UserInfoServiceInterface userInfoService;

    @PostMapping("/info")
    public void registerUserInfo(@RequestBody UserInfoRequestDto userInfoRequestDto) {
        userInfoService.saveUserInfo(userInfoRequestDto);
    }

    @PutMapping("/info")
    public void changeUserInfo(@RequestBody UserInfoUpdateRequestDto userInfoUpdateRequestDto) {
        userInfoService.updateUserInfo(userInfoUpdateRequestDto);
    }
}
