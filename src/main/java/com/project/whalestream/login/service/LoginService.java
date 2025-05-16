package com.project.whalestream.login.service;

import com.project.whalestream.login.dto.LoginRequestDto;
import com.project.whalestream.login.dto.LoginResponseDto;
import com.project.whalestream.login.dto.RepositoryPasswordReturnDto;
import com.project.whalestream.login.repository.UserRepository;
import com.project.whalestream.login.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements LoginServiceInterface {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        String requestId = loginRequestDto.getUserId();
        String requestPassword = loginRequestDto.getPassword();
        //이 아래에 일치하는지 확인도 로그인
        //이게 아이디로 비교하지말고 어차피 클라이언트가 입력한 아이디로 조회했을 때 비번이 없으면(Null 반환) 애초에 없던 계정이니
        //그냥 비번으로 조회하는게 편함
        RepositoryPasswordReturnDto repositoryPasswordReturnDto = userRepository.findOnlyPasswordById(requestId);

        //아디 비번없으면 예외로 넘기고 있으면 토큰 들어있는 LoginResponseDto를 넘겨주자
        if(repositoryPasswordReturnDto.getPassword() == null || !bcryptPasswordEncoder.matches(requestPassword, repositoryPasswordReturnDto.getPassword())) {
            throw new IllegalArgumentException("아이디 혹은 비밀번호가 일치하지 않습니다");
        } else {
            return new LoginResponseDto(requestId, jwtTokenProvider.generateToken(requestId));
        }
    }
}
