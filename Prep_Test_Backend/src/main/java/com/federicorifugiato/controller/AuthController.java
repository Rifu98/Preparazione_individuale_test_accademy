package com.federicorifugiato.controller;

import com.federicorifugiato.dto.UserLoginDTO;
import com.federicorifugiato.dto.UserSignupDTO;
import com.federicorifugiato.dto.UserDTO;
import com.federicorifugiato.service.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthController {

    @Autowired
    private UserService userService;

    @POST
    @Path("/signup")
    public Response signUp(@Valid UserSignupDTO userSignupDTO) {
        UserDTO userDTO = userService.signUp(userSignupDTO);
        return Response.status(Response.Status.CREATED).entity(userDTO).build();
    }

    @POST
    @Path("/signin")
    public Response signIn(@Valid UserLoginDTO userLoginDTO) {
        UserDTO userDTO = userService.signIn(userLoginDTO);
        return Response.ok(userDTO).build();
    }
}
