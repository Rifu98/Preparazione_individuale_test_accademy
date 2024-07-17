package com.federicorifugiato.service;

import com.federicorifugiato.dto.UserDTO;
import com.federicorifugiato.dto.UserSignupDTO;
import com.federicorifugiato.dto.UserLoginDTO;

import java.util.List;

public interface UserService {
    UserDTO signUp(UserSignupDTO userSignupDTO);
    UserDTO signIn(UserLoginDTO userLoginDTO);
    UserDTO findById(Integer id);
    List<UserDTO> findAll();
    void deleteUser(Integer id);
}

