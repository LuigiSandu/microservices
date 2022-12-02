package com.edc.pps.user.dto;

import com.edc.pps.user.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public UserResponse toDto(User user) {
        if (user == null) {
            return null;
        }
        UserResponse dto = new UserResponse();
        dto.setUserId(user.getUserId());
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUserName());
        return dto;
    }

    public List<UserResponse> toDto(List<User> users) {
        if (users == null) {
            return null;
        }
        List<UserResponse> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(toDto(user));
        }
        return dtos;
    }

    public User toEntity(UserRequest userRequest) {
        if (userRequest == null) {
            return null;
        }
        User entity = new User();
        entity.setPassword(userRequest.getPassword());
        entity.setUserName(userRequest.getUsername());
        return entity;
    }

    public List<User> toEntity(List<UserRequest> userRequests) {
        if (userRequests == null) {
            return null;
        }
        List<User> ratings = new ArrayList<>();
        for (UserRequest userRequest : userRequests) {
            ratings.add(toEntity(userRequest));
        }
        return ratings;
    }

}
