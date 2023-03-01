package com.connectbase.userservice.mapper;

import com.connectbase.userservice.dto.UserDto;
import com.connectbase.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public UserDto toUserDto(User user) {
        return new UserDto(
                user.getLoginId(),
                user.getFullName(),
                user.getDob(),
                user.getGender()
        );
    }

    @Override
    public User toUser(UserDto userDto) {
        User user = new User();
        user.setDob(userDto.getDob());
        user.setGender(userDto.getGender());
        user.setLoginId(userDto.getLoginId());
        user.setFullName(userDto.getFullName());
        return user;
    }
}
