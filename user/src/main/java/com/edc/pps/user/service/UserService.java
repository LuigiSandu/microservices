package com.edc.pps.user.service;

import com.edc.pps.user.dto.*;
import com.edc.pps.user.exception.*;
import com.edc.pps.user.model.User;
import com.edc.pps.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {


    public final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse save(UserRequest userRequest) {
        //checking request for null fields
        validateUserRequest(userRequest);
        List<User> users = userRepository.findAll();
        //check if user already exists by checking username and password
        if (users.stream().filter(entry -> entry.getUserName().equals(userRequest.getUsername())).count() == 1) {
            log.info("User with username: " + userRequest.getUsername() + " already exists");
            throw new UserAlreadyExistsException("USER ALREADY EXISTS");
        } else {
            User user = userMapper.toEntity(userRequest);
            userRepository.save(user);
            log.info(user + " has been saved to db");
            return userMapper.toDto(user);
        }

    }

    public void delete(long id) {
        //if rating with id exists, delete
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            log.info("User with ID: " + id + " has been deleted.");
        } else {
            throw new UserDoesntExistException("No user with ID: " + id);
        }

    }

    private void validateUserRequest(UserRequest userRequest) {
        if (userRequest.getUsername() == null) {
            throw new NullRequestException("Username cannot be null.");
        }
        if (userRequest.getPassword() == null) {
            throw new NullRequestException("Password cannot be null.");
        }
        if (userRequest.getUsername().length() < 8) {
            throw new UsernameLengthException("Username must be at least 8 characters long");
        }
        if (userRequest.getPassword().length() < 8) {
            throw new PasswordLengthException("Password must be at least 8 characters long");
        }

    }


}
