package com.resteasy.springboot.domain.response;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author huangsy
 * @date 2018/4/3 14:53
 */
@XmlRootElement(name="FilmList")
@XmlAccessorType(XmlAccessType.NONE)
public class FilmListDTO {
    @XmlAttribute(name = "FilmCount")
    private Integer filmCount;
    @XmlElementRef(name = "FilmInfo")
    private List<FilmInfoSimpleDTO> filmInfos;

    public Integer getFilmCount() {
        return filmCount;
    }

    public void setFilmCount(Integer filmCount) {
        this.filmCount = filmCount;
    }

    public List<FilmInfoSimpleDTO> getFilmInfos() {
        return filmInfos;
    }

    public void setFilmInfos(List<FilmInfoSimpleDTO> filmInfos) {
        this.filmInfos = filmInfos;
    }
}
