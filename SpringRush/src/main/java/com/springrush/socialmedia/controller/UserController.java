package com.springrush.socialmedia.controller;

import com.springrush.socialmedia.dto.request.UserRequest;
import com.springrush.socialmedia.dto.response.UserResponse;
import com.springrush.socialmedia.entity.UserEntity;
import com.springrush.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/create")
    public UserEntity Create(@RequestBody UserRequest user) {
        return userService.create(user);
    }

    @GetMapping("searchById/{username}")
    public UserResponse GetUser(@PathVariable String username) {
        return userService.getUserById(username);
    }

    @GetMapping("/getAll")
    public List<UserEntity> GetAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return "User Deleted Successfully";
    }

    @PutMapping("updateUser/{id}")
    public String updateUser(@PathVariable Long id,@RequestBody UserEntity user) {
        userService.updateUser(id, user);
        return "user Successfully Updated";
    }


    @GetMapping("byEmail/{email}")
    public UserResponse getByEmail( @PathVariable String email) {
        return userService.getUserByEmail(email);
    }
}
