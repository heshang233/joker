package com.resteasy.springboot.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

/**
 * @author huangsy
 * @date 2018/4/3 14:54
 */
@XmlRootElement(name="FilmInfo")
@XmlAccessorType(XmlAccessType.NONE)
public class FilmInfoDTO{
    @XmlElement(name = "FilmUUID")
    @JsonProperty("uuid")
    private String uuid;
    @XmlElement(name = "FilmAdminID")
    @JsonProperty("admin_id")
    private String adminId = "test123";
    @XmlElement(name = "Duration")
    @JsonProperty("duration")
    private Long duration;
    @XmlElement(name = "Place")
    @JsonProperty("place")
    private String place;
    @XmlElementRef(name = "MultilingualList")
    @JsonProperty("multilingual_list")
    private MultilingualListDTO multilingualListDTO;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public MultilingualListDTO getMultilingualListDTO() {
        return multilingualListDTO;
    }

    public void setMultilingualListDTO(MultilingualListDTO multilingualListDTO) {
        this.multilingualListDTO = multilingualListDTO;
    }
}
