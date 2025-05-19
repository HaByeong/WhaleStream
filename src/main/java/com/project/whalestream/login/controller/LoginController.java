package com.project.whalestream.login.controller;

import com.project.whalestream.login.dto.LoginRequestDto;
import com.project.whalestream.login.dto.LoginResponseDto;
import com.project.whalestream.login.dto.SignUpRequestDto;
import com.project.whalestream.login.dto.UserUpdateRequestDto;
import com.project.whalestream.login.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // HTTP 요청을 처리하는 컨트롤러를 의미
@RequestMapping("/ai")
public class LoginController {

    private final SignUpUseCase signUpUseCase;
    private final LoginServiceInterface loginService;
    private final UserUpdateServiceInterface userUpdateService;
    private final UserLogOutInterface userLogOutService;

    @PostMapping("/login")
    public LoginResponseDto loginMethod(@RequestBody LoginRequestDto loginRequestDto) {
        // loginservice 실행해가지고!! 이제 일치하면~~ login 그리고 토큰을 지급한다.

        //사실 return은 LoginResponseDto를 해줘야한다. -> 토큰 발급해줘야지
        //맞으면 service에서 토큰을 발급하여 LoginResponseDto에 넣고 그걸 반환

        return loginService.login(loginRequestDto);
    }

    @PostMapping("/sign-up")
    public String signupMethod(@RequestBody SignUpRequestDto signupRequestDto) {
        //회원가입 로직 처리
        signUpUseCase.newUser(signupRequestDto);
        return "회원 가입 완료";
    }

    @PostMapping("/log-out")
    public void logoutMetgod(){
        userLogOutService.logout();
    };

    @PostMapping("/user-update")
    public String modifyMethod(@RequestBody UserUpdateRequestDto userUpdateDto) {
        //일단 검증하고나서, 이후 로직
        userUpdateService.updateUser(userUpdateDto);
        return "사용자 변경이 완료되었습니다.";
    }


}
