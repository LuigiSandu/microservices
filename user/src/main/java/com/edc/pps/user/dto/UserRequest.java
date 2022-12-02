package com.edc.pps.user.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Data
@ToString
public class UserRequest {
   private String username;
   private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRequest that = (UserRequest) o;
        return username.equals(that.username) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}