package com.springrush.socialmedia.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;
}
