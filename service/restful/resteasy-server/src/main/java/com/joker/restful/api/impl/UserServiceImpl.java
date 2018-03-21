package com.joker.restful.api.impl;

import com.joker.restful.api.UserService;
import com.joker.restful.dto.FasterXmlDTO;
import com.joker.restful.dto.TestDTO;
import com.joker.restful.holder.TestHolder;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.PathSegment;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangsy
 * @date 2018/1/27 13:05
 */
@Component
public class UserServiceImpl implements UserService {

    @Override
    public String get() {
        return "hello world";
    }

    @Override
    public TestDTO postStr(TestDTO testDTO) {
        return testDTO;
    }

    @Override
    public String pathSegement(PathSegment id, String name) {
        return name;
    }

    @Override
    public FasterXmlDTO xml(FasterXmlDTO fasterXmlDTO) {
        return fasterXmlDTO;
    }

    @Override
    public FasterXmlDTO getxml() {
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
        return fasterXmlDTO;
    }

    @Override
    public String testHolder(String message) {
        String enabled = TestHolder.isEnabled();
        System.out.println("=============holder boolean:"+enabled);
        TestHolder.disable(message);
        System.out.println("=============holder disable");
        TestHolder.remove();
        return enabled;
    }
}
