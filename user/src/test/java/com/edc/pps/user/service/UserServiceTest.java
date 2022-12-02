package com.edc.pps.user.service;

import com.edc.pps.user.dto.UserResponse;
import com.edc.pps.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void givenUser_whenCreate_thenReturnUser(){
        // given

    }

}