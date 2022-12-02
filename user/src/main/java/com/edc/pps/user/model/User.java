package com.edc.pps.user.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Setter(AccessLevel.NONE)
    private Long userId;
    @Column(name = "user_name")
    @NotNull
    @Size(min = 8)
    private String userName;

    @NotNull
    @Size(min = 8)
    private String password;


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}
