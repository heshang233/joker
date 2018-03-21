package com.joker.restful.api;

import com.joker.restful.dto.FasterXmlDTO;
import com.joker.restful.dto.TestDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 * @author huangsy
 * @date 2018/1/27 13:04
 */
@Path("/users")
public interface UserService {
    @GET
    String get();

    @POST
    @Path("{testdto}")
    @Produces(MediaType.APPLICATION_JSON)
    TestDTO postStr(@PathParam("testdto")TestDTO testDTO);

    @GET
    @Path("/{id}/{name}")
    String pathSegement(@PathParam("id")PathSegment id, @PathParam("name") String name);

    @POST
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    FasterXmlDTO xml(FasterXmlDTO fasterXmlDTO);

    @POST
    @Path("/getxml")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    FasterXmlDTO getxml();

    @GET
    @Path("/testholder/{message}")
    String testHolder(@PathParam("message")String message);
}
