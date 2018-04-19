package com.joker.restful.fasterxml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.joker.restful.util.FilmInfoDTO;
import com.joker.restful.util.FilmListDTO;
import com.joker.restful.util.FilmListResultDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangsy
 * @date 2018/3/21 8:36
 */
public class Test {

    public static void main(String[] args) throws Exception {
        FasterXmlTest2 fasterXmlTest2 = new FasterXmlTest2();

        fasterXmlTest2.setId(12L);
        fasterXmlTest2.setValue("hehehhe");

        FasterXmlTest2 fasterXmlTest3 = new FasterXmlTest2();

        fasterXmlTest3.setId(13L);
        fasterXmlTest3.setValue("hehehh2e");

        FasterXmlTest2 fasterXmlTest4 = new FasterXmlTest2();

        fasterXmlTest4.setId(14L);
        fasterXmlTest4.setValue("heheh3he");

        fasterXmlTest2.getFasterXmlTest2s().add(fasterXmlTest3);
        fasterXmlTest2.getFasterXmlTest2s().add(fasterXmlTest4);

        FasterXmlList fasterXmlList = new FasterXmlList();
        fasterXmlList.setId(11L);
        fasterXmlList.setValue("ddddd");

        FasterXmlList fasterXmlList1 = new FasterXmlList();
        fasterXmlList1.setId(122L);
        fasterXmlList1.setValue("dd22ddd");

        fasterXmlTest2.getFasterXmlLists().add(fasterXmlList);
        fasterXmlTest2.getFasterXmlLists().add(fasterXmlList1);

        /*FilmListResultDTO filmListResultDTO = new FilmListResultDTO();

        filmListResultDTO.setStatus(0);
        FilmListDTO filmListDTO = new FilmListDTO();

        List<FilmInfoDTO> filmInfoDTOS = new ArrayList<>();
        FilmInfoDTO filmInfoDTO1 = new FilmInfoDTO();
        filmInfoDTO1.setActor("21123");
        filmInfoDTO1.setAdminId("1312332");
        filmInfoDTO1.setDescription("21fasd");
        filmInfoDTO1.setDirector("fsfsd");
        filmInfoDTO1.setDuration(100000L);
        filmInfoDTO1.setLanguage("CN");
        filmInfoDTO1.setName("asdasd");
        filmInfoDTO1.setPlace("dasdasd");
        filmInfoDTO1.setType("sda");
        filmInfoDTO1.setUuid("dasdasd");

        FilmInfoDTO filmInfoDTO2 = new FilmInfoDTO();
        filmInfoDTO2.setActor("21123");
        filmInfoDTO2.setAdminId("1312332");
        filmInfoDTO2.setDescription("21fasd");
        filmInfoDTO2.setDirector("fsfsd");
        filmInfoDTO2.setDuration(100000L);
        filmInfoDTO2.setLanguage("CN");
        filmInfoDTO2.setName("asdasd");
        filmInfoDTO2.setPlace("dasdasd");
        filmInfoDTO2.setType("sda");
        filmInfoDTO2.setUuid("dasdasd");

        filmInfoDTOS.add(filmInfoDTO1);
        filmInfoDTOS.add(filmInfoDTO2);

        filmListDTO.setFilmCount(2);
        filmListDTO.setFilmInfos(filmInfoDTOS);

        filmListResultDTO.setFilmListDTO(filmListDTO);*/

        XmlMapper xmlMapper = new XmlMapper();
        String string = xmlMapper.writeValueAsString(fasterXmlTest2);
        System.out.println("============="+string);
        FasterXmlTest2 fooRead = xmlMapper.readValue(string, FasterXmlTest2.class);
        System.out.println("=============");

    }
}
