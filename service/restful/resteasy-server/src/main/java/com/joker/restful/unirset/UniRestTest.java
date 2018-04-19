package com.joker.restful.unirset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.joker.restful.dto.FasterXmlDTO;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.xml.bind.JAXBContext;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangsy
 * @date 2018/3/20 10:59
 */
public class UniRestTest {
    public static void main(String[] args) {

        Unirest.setObjectMapper(new UnirestXmlObjectMapper());

        FasterXmlDTO fasterXmlDTO = new FasterXmlDTO();
        fasterXmlDTO.setI1(2121);
        fasterXmlDTO.setA1("123");
        fasterXmlDTO.setA2("223");
        fasterXmlDTO.setA3("323");
        FasterXmlDTO fasterXmlDTO1 = new FasterXmlDTO();
        fasterXmlDTO1.setA1("123");
        fasterXmlDTO1.setA2("223");
        fasterXmlDTO1.setA3("323");
        FasterXmlDTO fasterXmlDTO2 = new FasterXmlDTO();
        fasterXmlDTO2.setA1("123");
        fasterXmlDTO2.setA2("223");
        fasterXmlDTO2.setA3("323");
        FasterXmlDTO fasterXmlDTO3 = new FasterXmlDTO();
        fasterXmlDTO3.setA1("123");
        fasterXmlDTO3.setA2("223");
        fasterXmlDTO3.setA3("323");

//        fasterXmlDTO.setF1(fasterXmlDTO1);
        List<FasterXmlDTO> fasterXmlDTOS = new ArrayList<>();
        fasterXmlDTOS.add(fasterXmlDTO2);
        fasterXmlDTOS.add(fasterXmlDTO3);

        fasterXmlDTO.setL1(fasterXmlDTOS);

        try {
            HttpResponse<FasterXmlDTO> postResponse = Unirest.post("http://localhost:8081/resteasy-server/users/xml")
                    .header("accept", "application/xml")
                    .header("Content-Type", "application/xml")
                    .body(fasterXmlDTO)
                    .asObject(FasterXmlDTO.class);
            FasterXmlDTO fasterXmlDTO4 = postResponse.getBody();
            System.out.println("============完结撒花===============");
        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }
}
