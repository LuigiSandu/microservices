package com.edc.pps.user.controller;

import com.edc.pps.user.dto.UserRequest;
import com.edc.pps.user.dto.UserResponse;
import com.edc.pps.user.exception.NullRequestException;
import com.edc.pps.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.save(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
