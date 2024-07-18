package com.federicorifugiato.service;

import com.federicorifugiato.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO findById(Integer id);
    UserDTO findByEmail(String email);
    List<UserDTO> findAll();
    void deleteUser(Integer id);
}

