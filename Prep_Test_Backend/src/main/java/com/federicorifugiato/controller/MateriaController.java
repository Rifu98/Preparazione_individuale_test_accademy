package com.federicorifugiato.controller;

import com.federicorifugiato.dto.MateriaDTO;
import com.federicorifugiato.service.MateriaService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Path("/materie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @POST
    public Response createMateria(@Valid MateriaDTO materiaDTO) {
        MateriaDTO createdMateria = materiaService.createMateria(materiaDTO);
        return Response.status(Response.Status.CREATED).entity(createdMateria).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        MateriaDTO materiaDTO = materiaService.findById(id);
        return Response.ok(materiaDTO).build();
    }

    @GET
    public Response findAll() {
        List<MateriaDTO> materie = materiaService.findAll();
        return Response.ok(materie).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMateria(@PathParam("id") Integer id) {
        materiaService.deleteMateria(id);
        return Response.noContent().build();
    }
}
