package com.connectbase.userservice.repository;

import com.connectbase.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findUserByLoginId(String loginId);

}
