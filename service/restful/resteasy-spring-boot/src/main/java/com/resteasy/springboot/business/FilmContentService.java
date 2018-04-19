package com.resteasy.springboot.business;

import com.resteasy.springboot.domain.request.GetFilmFtpRequestDTO;
import com.resteasy.springboot.domain.request.GetFilmInfoRequestDTO;
import com.resteasy.springboot.domain.request.GetFilmListRequestDTO;
import com.resteasy.springboot.domain.response.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author huangsy
 * @date 2018/4/19 10:11
 */
@Path("/")
public interface FilmContentService {

    @POST
    @Path("/FilmServices/AddFilmInfo")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    FilmListResultDTO addFilmContent(FilmInfoDTO dto);

    @POST
    @Path("/FilmServices/AddFilmDCP")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    FilmListResultDTO addFilmFtp(FilmFtpDTO dto) throws Exception;

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
