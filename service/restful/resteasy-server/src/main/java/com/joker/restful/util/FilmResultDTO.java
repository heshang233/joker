package com.joker.restful.util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author huangsy
 * @date 2018/4/9 10:03
 */
@XmlRootElement(name="FasterXmlDTO")
@XmlAccessorType(XmlAccessType.NONE)
public class FilmResultDTO<T> {
    @XmlAttribute(name = "Status")
    private Integer status;
    @JacksonXmlProperty(localName = "Error")
    private String error;

    private T content;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
