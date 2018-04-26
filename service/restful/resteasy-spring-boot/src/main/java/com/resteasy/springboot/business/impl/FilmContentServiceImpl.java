package com.resteasy.springboot.business.impl;

import com.resteasy.springboot.business.FilmContentService;
import com.resteasy.springboot.domain.request.GetFilmFtpRequestDTO;
import com.resteasy.springboot.domain.request.GetFilmInfoRequestDTO;
import com.resteasy.springboot.domain.request.GetFilmListRequestDTO;
import com.resteasy.springboot.domain.response.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author huangsy
 * @date 2018/4/19 10:10
 */
@Component
public class FilmContentServiceImpl implements FilmContentService {

    private static Map<String,MapDTO> map = new HashMap<>();

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();

        System.out.println("urn:uuid:"+uuid.toString());
    }

    @Override
    public List<FilmList> addFilmContent(FilmInfoDTO dto) {
        if (!StringUtils.isEmpty(dto.getUuid())&&map.containsKey(dto.getUuid())) {
            MapDTO mapDTO = map.get(dto.getUuid());
            mapDTO.setFilmInfoDTO(dto);
            map.put(dto.getUuid(),mapDTO);
        }else {
            String uuid = "urn:uuid:"+UUID.randomUUID().toString();
            dto.setUuid(uuid);
            MapDTO mapDTO = new MapDTO();
            mapDTO.setFilmInfoDTO(dto);
            map.put(uuid,mapDTO);
        }

        Collection<MapDTO> mapDTOs = map.values();


        List<FilmList> filmLists = new ArrayList<>();

        mapDTOs.forEach(mapInfo ->{
            FilmList filmList = new FilmList();
            filmList.setName(mapInfo.getFilmInfoDTO().getMultilingualListDTO().getMultilingualDTO().get(0).getName());
            filmList.setUuid(mapInfo.getFilmInfoDTO().getUuid());
            FilmFtpDTO filmFtpDTO = mapInfo.getFilmFtpDTO();
            if (filmFtpDTO!=null){
                String ftpPath = filmFtpDTO.getFtpPath();
                String substring = ftpPath.substring(ftpPath.lastIndexOf("/") + 1);
                filmList.setFile_name(substring);
            }
            filmLists.add(filmList);
        });

        return filmLists;
    }

    @Override
    public List<FilmList> addFilmFtp(FilmFtpDTO dto) throws Exception {

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

        List<FilmList> filmLists = new ArrayList<>();

        mapDTOs.forEach(mapInfo ->{
            FilmList filmList = new FilmList();
            filmList.setName(mapInfo.getFilmInfoDTO().getMultilingualListDTO().getMultilingualDTO().get(0).getName());
            filmList.setUuid(mapInfo.getFilmInfoDTO().getUuid());
            FilmFtpDTO filmFtpDTO = mapInfo.getFilmFtpDTO();
            if (filmFtpDTO!=null){
                String ftpPath = filmFtpDTO.getFtpPath();
                String substring = ftpPath.substring(ftpPath.lastIndexOf("/") + 1);
                filmList.setFile_name(substring);
            }
            filmLists.add(filmList);
        });

        return filmLists;
    }

    @Override
    public List<FilmList> getList() {
        Collection<MapDTO> mapDTOs = map.values();

        List<FilmList> filmLists = new ArrayList<>();

        mapDTOs.forEach(mapInfo ->{
            FilmList filmList = new FilmList();
            filmList.setName(mapInfo.getFilmInfoDTO().getMultilingualListDTO().getMultilingualDTO().get(0).getName());
            filmList.setUuid(mapInfo.getFilmInfoDTO().getUuid());
            FilmFtpDTO filmFtpDTO = mapInfo.getFilmFtpDTO();
            if (filmFtpDTO!=null){
                String ftpPath = filmFtpDTO.getFtpPath();
                String substring = ftpPath.substring(ftpPath.lastIndexOf("/") + 1);
                filmList.setFile_name(substring);
            }
            filmLists.add(filmList);
        });

        return filmLists;
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
