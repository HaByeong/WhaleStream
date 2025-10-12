package com.project.whalestream.login.service.auth;

import com.project.whalestream.login.domain.user.User;
import com.project.whalestream.login.repository.user.UserRepository;
import com.project.whalestream.login.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccessTokenReissueService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public String reissueAccessToken(String refreshToken) {

        //refreshToken 유효성 검증
        if (!jwtTokenProvider.validateToken(refreshToken)) {
            throw new IllegalArgumentException("유효하지 않은 Refresh Token입니다.");
        }

        String userId = jwtTokenProvider.getUserIdFromToken(refreshToken);
        User user = userRepository.findByUserId(userId);

        //클라이언트 refreshToken이랑 DB 저장 refreshToken이랑 비교
        if (!refreshToken.equals(user.getJwtRefreshToken())) {
            throw new IllegalArgumentException("RefreshToken이 일치하지 않습니다.");
        }

        return jwtTokenProvider.generateAccessToken(userId);
    }

}
