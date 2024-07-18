package com.federicorifugiato.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Random;

import com.federicorifugiato.dao.UserDao;
import com.federicorifugiato.dto.UserDTO;
import com.federicorifugiato.dto.UserLoginDTO;
import com.federicorifugiato.dto.UserSignupDTO;
import com.federicorifugiato.model.Role;
import com.federicorifugiato.model.User;
import com.federicorifugiato.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserDao userDao;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int INVITE_CODE_LENGTH = 10;
    private Random random = new SecureRandom();
    private ModelMapper modelMapper = new ModelMapper();
    
	@Override
	public void signUp(UserSignupDTO userSignupDTO) {
	    User user = modelMapper.map(userSignupDTO, User.class);
	    user.setPassword(DigestUtils.sha256Hex(userSignupDTO.getPassword()));
	    user.setRuolo(Role.user);
        user.setCodiceInvito(generateUniqueInviteCode());
	    user = userDao.save(user);
	}
	
	@Override
	public UserDTO signIn(UserLoginDTO userLoginDTO) {
	    User user = userDao.findByEmail(userLoginDTO.getEmail()).get();
	    if (user == null || !user.getPassword().equals(DigestUtils.sha256Hex(userLoginDTO.getPassword()))) {
	        throw new RuntimeException("Invalid email or password");
	    }
	    return modelMapper.map(user, UserDTO.class);
	}

    private String generateUniqueInviteCode() {
        String inviteCode;
        do {
            inviteCode = generateInviteCode();
        } while (userDao.existsByCodiceInvito(inviteCode));
        return inviteCode;
    }

    private String generateInviteCode() {
        StringBuilder inviteCode = new StringBuilder(INVITE_CODE_LENGTH);
        for (int i = 0; i < INVITE_CODE_LENGTH; i++) {
            inviteCode.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return inviteCode.toString();
    }
    
}

