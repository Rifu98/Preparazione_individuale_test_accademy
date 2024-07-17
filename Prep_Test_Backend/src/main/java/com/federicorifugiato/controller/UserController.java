package com.federicorifugiato.controller;

import com.federicorifugiato.dto.UserDTO;
import com.federicorifugiato.service.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Autowired
    private UserService userService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        UserDTO userDTO = userService.findById(id);
        return Response.ok(userDTO).build();
    }

    @GET
    public Response findAll() {
        List<UserDTO> users = userService.findAll();
        return Response.ok(users).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Integer id) {
        userService.deleteUser(id);
        return Response.noContent().build();
    }
}
