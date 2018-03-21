package com.joker.restful.fasterxml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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

        XmlMapper xmlMapper = new XmlMapper();
        String string = xmlMapper.writeValueAsString(fasterXmlTest2);
        System.out.println("============="+string);
        FasterXmlTest2 fooRead = xmlMapper.readValue(string, FasterXmlTest2.class);
        System.out.println("=============");

    }
}
