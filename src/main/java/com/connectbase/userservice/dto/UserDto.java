package com.connectbase.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String loginId;
    private String fullName;
    private Instant dob;
    private Character gender;

}
