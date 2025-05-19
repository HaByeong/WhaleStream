package com.project.whalestream.login.service.auth;

import com.project.whalestream.login.domain.user.User;
import com.project.whalestream.login.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserLogOutService implements UserLogOutInterface{

    private final UserRepository userRepository;

    @Override
    public void logout() {
        //Dto로 유저 Id를 받으면 보안상 좋지 않다.
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUserId(userId);
        user.setJwtRefreshToken(null);
        userRepository.save(user);
    }
}
