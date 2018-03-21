package com.joker.restful.fasterxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangsy
 * @date 2018/3/21 8:29
 */
//@JacksonXmlRootElement(localName = "FasterXmlTest2")
public class FasterXmlTest2 {
    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    private String value;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "FasterXmlTest")
    private List<FasterXmlTest2> fasterXmlTest2s = new ArrayList<>();

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "FasterXmlList")
    private List<FasterXmlList> fasterXmlLists = new ArrayList<>();

    public List<FasterXmlTest2> getFasterXmlTest2s() {
        return fasterXmlTest2s;
    }

    public void setFasterXmlTest2s(List<FasterXmlTest2> fasterXmlTest2s) {
        this.fasterXmlTest2s = fasterXmlTest2s;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<FasterXmlList> getFasterXmlLists() {
        return fasterXmlLists;
    }

    public void setFasterXmlLists(List<FasterXmlList> fasterXmlLists) {
        this.fasterXmlLists = fasterXmlLists;
    }
}
