package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username", unique = true, nullable = false, length = 100)
    private String username;
    @Column(name="password", unique = true, nullable = false, length = 100)
    private String password;
    @Column(name="name", unique = true, nullable = false, length = 100)
    private String name;
    @Column(name="creationTime", nullable = false)
    private LocalDateTime creationTime;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private String token;

}
