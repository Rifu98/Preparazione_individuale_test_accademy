package com.federicorifugiato.controller;

import com.federicorifugiato.dto.UserLoginDTO;
import com.federicorifugiato.dto.UserLoginResponseDTO;
import com.federicorifugiato.dto.UserSignupDTO;
import com.federicorifugiato.dto.UserDTO;
import com.federicorifugiato.service.AuthService;
import com.federicorifugiato.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @POST
    @Path("/signup")
    public Response signUp(@Valid UserSignupDTO userSignupDTO) {
        authService.signUp(userSignupDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/signin")
    public Response signIn(@Valid UserLoginDTO userLoginDTO) {
        UserDTO userDTO = authService.signIn(userLoginDTO);
        UserLoginResponseDTO token = issueToken(userDTO.getEmail());
        return Response.ok(token).build();
    }
    
	public UserLoginResponseDTO issueToken (String email) {
	    
	      byte[] secret = "33trentinientraronoatrentotuttie33trotterellando1234567890".getBytes();
	      Key key = Keys.hmacShaKeyFor(secret);
	      
	      UserDTO informazioniUtente = userService.findByEmail(email);
	      Map<String, Object> map = new HashMap<>();
	      map.put("nome", informazioniUtente.getNome());
	      map.put("cognome", informazioniUtente.getCognome());
	      map.put("email", email);
	      map.put("ruolo", informazioniUtente.getRuolo());

	      Date creation = new Date();
	      Date end = java.sql.Timestamp.valueOf(LocalDateTime.now().plusMinutes(15L));
	      
	      String tokenJwts = Jwts.builder()
	    		  .setClaims(map)
	    		  .setIssuer("http://localhost:8080")
	    		  .setIssuedAt(creation)
	    		  .setExpiration(end)
	    		  .signWith(key)
	    		  .compact();
	      
	      UserLoginResponseDTO token = new UserLoginResponseDTO();
	      
	      token.setToken(tokenJwts);
	      token.setTct(creation);
	      token.setTtl(end);
	      
	      return token;
		
	}
}
