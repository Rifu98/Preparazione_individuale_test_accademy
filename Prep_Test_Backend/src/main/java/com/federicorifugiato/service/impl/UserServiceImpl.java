package com.federicorifugiato.service.impl;

import com.federicorifugiato.dto.UserDTO;
import com.federicorifugiato.model.User;
import com.federicorifugiato.dao.UserDao;
import com.federicorifugiato.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserDTO findById(Integer id) {
        User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        return userDao.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }

	@Override
	public UserDTO findByEmail(String email) {
        User user = userDao.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserDTO.class);
	}
}
