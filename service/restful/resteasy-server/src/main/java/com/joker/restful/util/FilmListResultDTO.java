package com.joker.restful.util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.*;

/**
 * @author huangsy
 * @date 2018/4/9 10:03
 */
@XmlRootElement(name="Result")
@XmlAccessorType(XmlAccessType.NONE)
public class FilmListResultDTO {

    @XmlAttribute(name = "Status")
    private Integer status;
    @XmlElement(name = "Error")
    private String error;
    @XmlElementRef(name = "FilmList")
    private FilmListDTO filmListDTO;

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

    public FilmListDTO getFilmListDTO() {
        return filmListDTO;
    }

    public void setFilmListDTO(FilmListDTO filmListDTO) {
        this.filmListDTO = filmListDTO;
    }
}
