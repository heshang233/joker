package com.resteasy.springboot.domain.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author huangsy
 * @date 2018/4/16 8:45
 */
@XmlRootElement(name="Multilingual")
@XmlAccessorType(XmlAccessType.NONE)
public class MultilingualDTO {
    @XmlElement(name = "FilmName")
    private String name;
    @XmlElement(name = "Language")
    private String languageCode;
    @XmlElement(name = "Director")
    private String director;
    @XmlElement(name = "Starring")
    private String actor;
    @XmlElement(name = "FilmType")
    private String type;
    @XmlElement(name = "Description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
