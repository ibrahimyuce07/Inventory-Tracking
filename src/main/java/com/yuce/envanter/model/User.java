package com.yuce.envanter.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yuce.envanter.BCryptPasswordDeserializer;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Data
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private int id;
    private String firstName;
    private String lastName;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    @JsonDeserialize(using = BCryptPasswordDeserializer.class)
    private String password;
    private RoleEnum role;


}
