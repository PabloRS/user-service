package com.connectbase.userservice.service;

import com.connectbase.userservice.dto.UserDto;
import com.connectbase.userservice.model.User;
import com.connectbase.userservice.repository.UserRepository;
import com.connectbase.userservice.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    public static final String LOGIN_ID = UUID.randomUUID().toString();
    public static final Character GENDER = 'M';
    public static final Instant DOB = Instant.now();
    public static final String NAME = "PabloRS";

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void init() {
        userService = new UserServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findUserByLoginIdTest() {
        Mockito.lenient().when(userRepository.findUserByLoginId(Mockito.any(String.class)))
                .thenReturn(simulateResponse());
        UserDto userDto = userService.searchUser(LOGIN_ID);
        assertNotNull(userDto);
        assertEquals(NAME, userDto.getFullName());
        assertEquals(LOGIN_ID, userDto.getLoginId());
        Mockito.verify(userRepository, Mockito.times(2))
                .findUserByLoginId(LOGIN_ID);
    }

    @Test
    public void createUser() {
        Mockito.lenient().when(userRepository.save(Mockito.any(User.class)))
                .thenReturn(simulateResponse());
        UserDto userDto = userService.createUser(simulateResponseDto());
        assertNotNull(userDto);
        assertEquals(LOGIN_ID, userDto.getLoginId());
        Mockito.verify(userRepository, Mockito.times(1))
                .findUserByLoginId(LOGIN_ID);
    }

    @Test
    public void updateUser() {
        Mockito.lenient().when(userRepository.findUserByLoginId(Mockito.any(String.class)))
                .thenReturn(simulateResponse());
        Mockito.lenient().when(userRepository.save(Mockito.any(User.class)))
                .thenReturn(updatedResponse());
        UserDto updatedUser = userService.updateUser(updatedResponseDto());
        assertNotNull(updatedUser);
        assertNotEquals(NAME, updatedUser.getFullName());
        Mockito.verify(userRepository, Mockito.times(2))
                .findUserByLoginId(LOGIN_ID);
    }


    private User simulateResponse() {
        User user = new User();
        user.setId(1L);
        user.setDob(DOB);
        user.setGender(GENDER);
        user.setLoginId(LOGIN_ID);
        user.setFullName(NAME);
        return user;
    }

    private UserDto simulateResponseDto() {
        UserDto user = new UserDto();
        user.setDob(DOB);
        user.setGender(GENDER);
        user.setLoginId(LOGIN_ID);
        user.setFullName(NAME);
        return user;
    }

    private User updatedResponse() {
        User user = new User();
        user.setDob(DOB);
        user.setGender(GENDER);
        user.setLoginId(LOGIN_ID);
        user.setFullName("New name");
        return user;
    }

    private UserDto updatedResponseDto() {
        UserDto user = new UserDto();
        user.setDob(DOB);
        user.setGender(GENDER);
        user.setLoginId(LOGIN_ID);
        user.setFullName("New name");
        return user;
    }
}
