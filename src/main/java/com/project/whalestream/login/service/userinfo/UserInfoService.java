package com.project.whalestream.login.service.userinfo;

import com.project.whalestream.login.domain.userinfo.UserInfo;
import com.project.whalestream.login.dto.userinfo.UserInfoRequestDto;
import com.project.whalestream.login.dto.userinfo.UserInfoUpdateRequestDto;
import com.project.whalestream.login.repository.userinfo.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInfoService implements UserInfoServiceInterface {

    private final UserInfoRepository userInfoRepository;

    @Override
    public void saveUserInfo(UserInfoRequestDto userInfoRequestDto) {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userinfo = new UserInfo(userId); // 생성자 안에 userInfoRequestDto.~~ 해서 넣어줘야함
        userInfoRepository.save(userinfo);
    }

    @Override
    public void updateUserInfo(UserInfoUpdateRequestDto userInfoUpdateRequestDto) {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userInfo = userInfoRepository.findByUserId(userId);
        //userInfo를 바꾸고~ (set ~~)
        userInfoRepository.save(userInfo);
    }
}
