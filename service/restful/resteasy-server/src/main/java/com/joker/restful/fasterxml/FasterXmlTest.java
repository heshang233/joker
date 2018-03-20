package com.joker.restful.fasterxml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.joker.restful.dto.FasterXmlDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangsy
 * @date 2018/3/20 8:53
 */
public class FasterXmlTest {
    static class Foo {
        @JacksonXmlElementWrapper(useWrapping = false)
        public List<Bar> firstBar = new ArrayList<Bar>();
        @JacksonXmlElementWrapper(useWrapping = false)
        public List<Bar> secondBar = new ArrayList<Bar>();
    }

    static class Bar {
        public String value;

        @JacksonXmlProperty(isAttribute = true)
        public int id;
    }
    public static void main(String[] args) throws Exception {

        /*XmlMapper xmlMapper = new XmlMapper();
        Foo foo = new Foo();
        Bar bar1 = new Bar();
        bar1.id = 1;
        bar1.value = "FIRST";
        foo.firstBar.add(bar1);
        Bar bar2 = new Bar();
        bar2.value = "SECOND";
        bar2.id = 2;
        foo.secondBar.add(bar2);
        foo.firstBar.add(bar2);
        String string = xmlMapper.writeValueAsString(foo);
        System.out.println("============="+string);
        Foo fooRead = xmlMapper.readValue(string, Foo.class);
        System.out.println("=============");*/
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

        List<FasterXmlDTO> fasterXmlDTOS = new ArrayList<>();
        fasterXmlDTOS.add(fasterXmlDTO2);
        fasterXmlDTOS.add(fasterXmlDTO3);

        fasterXmlDTO.setL1(fasterXmlDTOS);


        try {
            JacksonXmlModule module = new JacksonXmlModule();
            module.setDefaultUseWrapper(false);
            XmlMapper xmlMapper = new XmlMapper(module);
            xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            String xmlStr =  xmlMapper.writeValueAsString(fasterXmlDTO);
            System.out.println("=======");
            System.out.println(xmlStr);
            FasterXmlDTO fasterXmlDTO4 = xmlMapper.readValue(xmlStr, FasterXmlDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
