package com.connectbase.userservice.controller;

import com.connectbase.userservice.dto.UserDto;
import com.connectbase.userservice.exception.UserServiceException;
import com.connectbase.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) throws UserServiceException {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) throws UserServiceException {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @GetMapping("/{loginId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("loginId") String loginId) throws UserServiceException {
        return new ResponseEntity<>(userService.searchUser(loginId), HttpStatus.OK);
    }
}
