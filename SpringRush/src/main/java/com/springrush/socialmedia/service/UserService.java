package com.springrush.socialmedia.service;


import com.springrush.socialmedia.dto.request.UserRequest;
import com.springrush.socialmedia.dto.response.UserResponse;
import com.springrush.socialmedia.entity.UserEntity;
import com.springrush.socialmedia.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;


    public UserEntity convertToEntity(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setEmail(userRequest.getEmail());
        return userEntity;
    }

    public UserResponse convertToResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(userEntity.getUserName());
        userResponse.setEmail(userEntity.getEmail());
        userResponse.setId(userEntity.getId());
        return userResponse;
    }

    public UserEntity create(UserRequest user123) {
        UserEntity user= convertToEntity(user123);
       return userRepo.save(user);
    }


    public UserResponse getUserById(String username){
      UserEntity user = userRepo.findByUserName(username);
      return convertToResponse(user);
    }

    public List<UserEntity> getAllUsers(){
        return userRepo.findAll();
    }
    public void deleteById(Long id){
        userRepo.deleteById(id);
    }

    public String updateUser(Long id,UserEntity userEntity){
      UserEntity user = userRepo.findById(id).get();
      if(user==null){
          return "User not found";
      }
      user.setUserName(userEntity.getUserName());
      user.setPassword(userEntity.getPassword());
      user.setEmail(userEntity.getEmail());
      userRepo.save(user);
     return "User Successfully Updated";
    }

    public UserResponse getUserByEmail(String email){
    UserEntity user = userRepo.findByEmail(email);
    return convertToResponse(user);
    }

}
