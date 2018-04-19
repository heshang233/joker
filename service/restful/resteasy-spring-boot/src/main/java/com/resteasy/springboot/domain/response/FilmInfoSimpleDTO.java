package com.resteasy.springboot.domain.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author huangsy
 * @date 2018/4/16 8:52
 */
@XmlRootElement(name="FilmInfo")
@XmlAccessorType(XmlAccessType.NONE)
public class FilmInfoSimpleDTO {
    @XmlElement(name = "FilmUUID")
    private String uuid;
    @XmlElement(name = "FilmName")
    private String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
