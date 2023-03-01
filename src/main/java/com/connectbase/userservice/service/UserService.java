package com.connectbase.userservice.service;

import com.connectbase.userservice.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user);

    UserDto searchUser(String login);
}
