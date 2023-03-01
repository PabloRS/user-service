package com.connectbase.userservice.mapper;

import com.connectbase.userservice.dto.UserDto;
import com.connectbase.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "loginId", target = "loginId")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "dob", target = "dob")
    @Mapping(source = "gender", target = "gender")
    UserDto toUserDto(User user);

    @Mapping(source = "loginId", target = "loginId")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "dob", target = "dob")
    @Mapping(source = "gender", target = "gender")
    User toUser(UserDto userDto);
}
