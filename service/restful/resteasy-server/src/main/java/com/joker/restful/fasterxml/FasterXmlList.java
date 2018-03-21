package com.joker.restful.fasterxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author huangsy
 * @date 2018/3/21 8:33
 */
@JacksonXmlRootElement(localName = "FasterXmlList")
public class FasterXmlList {
    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    private String value;

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
}
