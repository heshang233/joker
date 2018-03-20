package com.joker.restful.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

import javax.xml.bind.annotation.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangsy
 * @date 2018/3/20 8:54
 */
@JacksonXmlRootElement(localName="FasterXmlDTO")
@XmlRootElement(name="FasterXmlDTO")
@XmlAccessorType(XmlAccessType.NONE)
public class FasterXmlDTO {


    @XmlElement
    private String a1;

    @JacksonXmlProperty(isAttribute =true)
    @XmlAttribute
    private int i1;

    @XmlElement
    private String a2;

    @XmlElement
    private String a3;

//    @XmlElement
//    private Instant instant = Instant.now();

    @JacksonXmlElementWrapper(useWrapping = false)
//    @JsonProperty("FasterXmlDTO")
    @JacksonXmlProperty(localName = "FasterXmlDTO")
    private List<FasterXmlDTO> l1 = new ArrayList<>();

    /*@XmlElementRef
    @JacksonXmlProperty(localName = "FasterXmlDTO")
    private FasterXmlDTO f1;*/

    public int getI1() {
        return i1;
    }

//    public Instant getInstant() {
//        return instant;
//    }
//
//    public void setInstant(Instant instant) {
//        this.instant = instant;
//    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public List<FasterXmlDTO> getL1() {
        return l1;
    }

    public void setL1(List<FasterXmlDTO> l1) {
        this.l1 = l1;
    }

/*    public FasterXmlDTO getF1() {
        return f1;
    }

    public void setF1(FasterXmlDTO f1) {
        this.f1 = f1;
    }*/
}
