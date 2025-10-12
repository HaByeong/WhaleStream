package com.project.whalestream.login.repository.userinfo;

import com.project.whalestream.login.domain.userinfo.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInfoRepository extends MongoRepository<UserInfo, String> {

    UserInfo findByUserId(String userId);
}
