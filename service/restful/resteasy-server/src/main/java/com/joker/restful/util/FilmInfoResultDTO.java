package com.joker.restful.util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.*;

/**
 * @author huangsy
 * @date 2018/4/9 10:10
 */
@XmlRootElement(name="Result")
@XmlAccessorType(XmlAccessType.NONE)
public class FilmInfoResultDTO {
    @XmlAttribute(name = "Status")
    private Integer status;
    @XmlElement(name = "Error")
    private String error;
    @XmlElementRef(name = "FilmInfo")
    private FilmInfoDTO filmInfoDTO;

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

    public FilmInfoDTO getFilmInfoDTO() {
        return filmInfoDTO;
    }

    public void setFilmInfoDTO(FilmInfoDTO filmInfoDTO) {
        this.filmInfoDTO = filmInfoDTO;
    }
}
