package com.project.whalestream.login.controller.user;

import com.project.whalestream.login.dto.user.UserUpdateRequestDto;
import com.project.whalestream.login.service.user.UserUpdateServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserUpdateController {

    private final UserUpdateServiceInterface userUpdateService;

    @PutMapping
    public String changeUser(@RequestBody UserUpdateRequestDto userUpdateDto) {
        //일단 검증하고나서, 이후 로직
        userUpdateService.updateUser(userUpdateDto);
        return "사용자 변경이 완료되었습니다.";
    }

}
