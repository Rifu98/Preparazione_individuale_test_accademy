package com.federicorifugiato.service;

import com.federicorifugiato.dto.UserDTO;
import com.federicorifugiato.dto.UserLoginDTO;
import com.federicorifugiato.dto.UserSignupDTO;

public interface AuthService {

    void signUp(UserSignupDTO userSignupDTO);
    UserDTO signIn(UserLoginDTO userLoginDTO);
}
