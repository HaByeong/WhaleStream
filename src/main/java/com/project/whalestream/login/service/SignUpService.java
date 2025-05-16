package com.project.whalestream.login.service;

import com.project.whalestream.login.domain.User;
import com.project.whalestream.login.dto.SignUpRequestDto;
import com.project.whalestream.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// 클라이언트의 회원가입 요청을 받아서 User 객체를 만듬, 비밀번호는 BCryptPasswordEncoder 이용해서 해싱
@Service
@RequiredArgsConstructor
public class SignUpService implements SignUpUseCase{
    //private User user = new User();
    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

    public void newUser(SignUpRequestDto signUpRequestDto) {
        User newUser = new User(signUpRequestDto.getUserId(),
                encoder.encode(signUpRequestDto.getPassword()),
                signUpRequestDto.getName(),
                signUpRequestDto.getAge(),
                signUpRequestDto.getEmail(),
                signUpRequestDto.getPhoneNum(),
                signUpRequestDto.getUserHeight()
        );
        userRepository.save(newUser);
        System.out.println("완료!");
    }
}
