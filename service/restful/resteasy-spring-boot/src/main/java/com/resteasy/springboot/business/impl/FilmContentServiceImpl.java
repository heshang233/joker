package com.resteasy.springboot.business.impl;

import com.resteasy.springboot.business.FilmContentService;
import com.resteasy.springboot.domain.request.GetFilmFtpRequestDTO;
import com.resteasy.springboot.domain.request.GetFilmInfoRequestDTO;
import com.resteasy.springboot.domain.request.GetFilmListRequestDTO;
import com.resteasy.springboot.domain.response.*;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author huangsy
 * @date 2018/4/19 10:10
 */
@Component
public class FilmContentServiceImpl implements FilmContentService {

    private static Map<String,MapDTO> map = new HashMap<>();

    @Override
    public FilmListResultDTO addFilmContent(FilmInfoDTO dto) {

        if (map.containsKey(dto.getUuid())) {
            MapDTO mapDTO = map.get(dto.getUuid());
            mapDTO.setFilmInfoDTO(dto);
            map.put(dto.getUuid(),mapDTO);
        }else {
            MapDTO mapDTO = new MapDTO();
            mapDTO.setFilmInfoDTO(dto);
            map.put(dto.getUuid(),mapDTO);
        }

        Collection<MapDTO> mapDTOs = map.values();

        FilmListResultDTO filmListResultDTO = new FilmListResultDTO();
        FilmListDTO filmListDTO = new FilmListDTO();

        List<FilmInfoSimpleDTO> filmInfoDTOS = new ArrayList<>();

        mapDTOs.forEach(mapInfo ->{
            FilmInfoSimpleDTO filmInfoSimpleDTO = new FilmInfoSimpleDTO();
            filmInfoSimpleDTO.setName(mapInfo.getFilmInfoDTO().getMultilingualListDTO().getMultilingualDTO().get(0).getName());
            filmInfoSimpleDTO.setUuid(mapInfo.getFilmInfoDTO().getUuid());
            filmInfoDTOS.add(filmInfoSimpleDTO);
        });

        filmListDTO.setFilmCount(map.size());
        filmListDTO.setFilmInfos(filmInfoDTOS);
        filmListResultDTO.setStatus(0);
        filmListResultDTO.setFilmListDTO(filmListDTO);

        return filmListResultDTO;
    }

    @Override
    public FilmListResultDTO addFilmFtp(FilmFtpDTO dto) throws Exception {

        if (map.containsKey(dto.getUuid())) {
            MapDTO mapDTO = map.get(dto.getUuid());
            if (mapDTO.getFilmInfoDTO()!=null){
                mapDTO.setFilmFtpDTO(dto);
                map.put(dto.getUuid(),mapDTO);
            }else {
                throw new Exception("no film!");
            }
        }else {
            throw new Exception("no film!");
        }

        Collection<MapDTO> mapDTOs = map.values();

        FilmListResultDTO filmListResultDTO = new FilmListResultDTO();
        FilmListDTO filmListDTO = new FilmListDTO();

        List<FilmInfoSimpleDTO> filmInfoDTOS = new ArrayList<>();

        mapDTOs.forEach(mapInfo ->{
            FilmInfoSimpleDTO filmInfoSimpleDTO = new FilmInfoSimpleDTO();
            filmInfoSimpleDTO.setName(mapInfo.getFilmInfoDTO().getMultilingualListDTO().getMultilingualDTO().get(0).getName());
            filmInfoSimpleDTO.setUuid(mapInfo.getFilmInfoDTO().getUuid());
            filmInfoDTOS.add(filmInfoSimpleDTO);
        });

        filmListDTO.setFilmCount(map.size());
        filmListDTO.setFilmInfos(filmInfoDTOS);
        filmListResultDTO.setStatus(0);
        filmListResultDTO.setFilmListDTO(filmListDTO);

        return filmListResultDTO;
    }

    @Override
    public FilmListResultDTO GetFilmList(GetFilmListRequestDTO dto) {
        System.out.println(dto.getPassword());
        System.out.println(dto.getUserName());
        System.out.println(dto.getReportDate());

        Collection<MapDTO> mapDTOs = map.values();

        FilmListResultDTO filmListResultDTO = new FilmListResultDTO();
        FilmListDTO filmListDTO = new FilmListDTO();

        List<FilmInfoSimpleDTO> filmInfoDTOS = new ArrayList<>();

        mapDTOs.forEach(mapInfo ->{
            FilmInfoSimpleDTO filmInfoSimpleDTO = new FilmInfoSimpleDTO();
            filmInfoSimpleDTO.setName(mapInfo.getFilmInfoDTO().getMultilingualListDTO().getMultilingualDTO().get(0).getName());
            filmInfoSimpleDTO.setUuid(mapInfo.getFilmInfoDTO().getUuid());
            filmInfoDTOS.add(filmInfoSimpleDTO);
        });

        filmListDTO.setFilmCount(map.size());
        filmListDTO.setFilmInfos(filmInfoDTOS);
        filmListResultDTO.setStatus(0);
        filmListResultDTO.setFilmListDTO(filmListDTO);

        return filmListResultDTO;
    }

    @Override
    public FilmInfoResultDTO GetFilmInfo(GetFilmInfoRequestDTO dto) {
        System.out.println(dto.getPassword());
        System.out.println(dto.getUserName());
        System.out.println(dto.getReportDate());
        System.out.println(dto.getUuid());


        FilmInfoResultDTO filmInfoResultDTO = new FilmInfoResultDTO();
        filmInfoResultDTO.setStatus(0);

        if (map.containsKey(dto.getUuid())) {
            MapDTO mapDTO = map.get(dto.getUuid());
            filmInfoResultDTO.setFilmInfoDTO(mapDTO.getFilmInfoDTO());
        }else {
            filmInfoResultDTO.setStatus(1);
            filmInfoResultDTO.setError("not found film!");
        }

        return filmInfoResultDTO;
    }

    @Override
    public FilmFtpResultDTO GetFilmDCP(GetFilmFtpRequestDTO dto) throws Exception {
        System.out.println(dto.getPassword());
        System.out.println(dto.getUserName());
        System.out.println(dto.getReportDate());
        System.out.println(dto.getUuid());

        FilmFtpResultDTO filmFtpResultDTO = new FilmFtpResultDTO();

        filmFtpResultDTO.setStatus(0);

        if (map.containsKey(dto.getUuid())) {
            MapDTO mapDTO = map.get(dto.getUuid());
            filmFtpResultDTO.setFilmFtpDTO(mapDTO.getFilmFtpDTO());
        }else {
            filmFtpResultDTO.setStatus(1);
            filmFtpResultDTO.setError("not found film!");
        }

        return filmFtpResultDTO;
    }

}
