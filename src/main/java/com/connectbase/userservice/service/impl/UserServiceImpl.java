package com.connectbase.userservice.service.impl;

import com.connectbase.userservice.dto.UserDto;
import com.connectbase.userservice.exception.UserServiceException;
import com.connectbase.userservice.mapper.UserMapper;
import com.connectbase.userservice.mapper.UserMapperImpl;
import com.connectbase.userservice.model.User;
import com.connectbase.userservice.repository.UserRepository;
import com.connectbase.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMapper mapper = new UserMapperImpl();

    @Override
    public UserDto createUser(UserDto user) {
        if(Objects.nonNull(userRepository.findUserByLoginId(user.getLoginId()))) {
            throw new RuntimeException();
        }
        User response = userRepository.save(mapper.toUser(user));
        return mapper.toUserDto(response);
    }

    @Override
    public UserDto updateUser(UserDto user) {
        if(Objects.isNull(userRepository.findUserByLoginId(user.getLoginId()))) {
            throw new UserServiceException();
        }
        User current = userRepository.findUserByLoginId(user.getLoginId());
        current.setFullName(user.getFullName());
        current.setGender(user.getGender());
        current.setDob(user.getDob());
        return mapper.toUserDto(userRepository.save(current));
    }

    @Override
    public UserDto searchUser(String login) {
        if(Objects.isNull(userRepository.findUserByLoginId(login))) {
            throw new UserServiceException();
        }
        return mapper.toUserDto(userRepository.findUserByLoginId(login));
    }
}
