package com.joker.restful.util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author huangsy
 * @date 2018/4/3 14:53
 */
@JacksonXmlRootElement(localName = "Result")
public class ResultDTO {
    @JacksonXmlProperty(isAttribute = true, localName = "Status")
    private Integer status1;
    @JacksonXmlProperty(localName = "Error")
    private String error;

    public Integer getStatus1() {
        return status1;
    }

    public void setStatus1(Integer status) {
        this.status1 = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
