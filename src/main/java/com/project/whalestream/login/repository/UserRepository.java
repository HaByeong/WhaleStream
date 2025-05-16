package com.project.whalestream.login.repository;

import com.project.whalestream.login.domain.User;
import com.project.whalestream.login.dto.RepositoryPasswordReturnDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    // 1: 은 포함시키겠다, 0은 포함시키지 않겠다 -> _id 얘는 그냥 자동으로 생성되서 알아서 막아줘야함
    @Query(value = "{'_id' : ?0}", fields = "{'password' : 1, '_id' : 0}")
    RepositoryPasswordReturnDto findOnlyPasswordById(String userId);

    User findByUserId(String userId);

}
