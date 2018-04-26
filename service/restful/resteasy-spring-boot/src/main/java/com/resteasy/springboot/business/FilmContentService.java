package com.resteasy.springboot.business;

import com.resteasy.springboot.domain.request.GetFilmFtpRequestDTO;
import com.resteasy.springboot.domain.request.GetFilmInfoRequestDTO;
import com.resteasy.springboot.domain.request.GetFilmListRequestDTO;
import com.resteasy.springboot.domain.response.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author huangsy
 * @date 2018/4/19 10:11
 */
@Path("/")
public interface FilmContentService {

    @POST
    @Path("/FilmServices/add-info")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<FilmList> addFilmContent(FilmInfoDTO dto);

    @POST
    @Path("/FilmServices/add-ftp")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<FilmList> addFilmFtp(FilmFtpDTO dto) throws Exception ;

    @GET
    @Path("/FilmServices/get-list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<FilmList> getList();

    @POST
    @Path("/FilmServices/GetFilmList")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    FilmListResultDTO GetFilmList(GetFilmListRequestDTO dto);

    @POST
    @Path("/FilmServices/GetFilmInfo")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    FilmInfoResultDTO GetFilmInfo(GetFilmInfoRequestDTO dto);

    @POST
    @Path("/FilmServices/GetFilmDCP")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    FilmFtpResultDTO GetFilmDCP(GetFilmFtpRequestDTO dto) throws Exception;
}
