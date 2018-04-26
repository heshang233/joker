package com.resteasy.springboot.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("name")
    private String name;
    @XmlElement(name = "Language")
    @JsonProperty("language_code")
    private String languageCode;
    @XmlElement(name = "Director")
    @JsonProperty("director")
    private String director;
    @XmlElement(name = "Starring")
    @JsonProperty("actor")
    private String actor;
    @XmlElement(name = "FilmType")
    @JsonProperty("type")
    private String type;
    @XmlElement(name = "Description")
    @JsonProperty("description")
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
