package com.resteasy.springboot.domain.response;

import javax.xml.bind.annotation.*;

/**
 * @author huangsy
 * @date 2018/4/3 14:54
 */
@XmlRootElement(name="FilmInfo")
@XmlAccessorType(XmlAccessType.NONE)
public class FilmInfoDTO{
    @XmlElement(name = "FilmUUID")
    private String uuid;
    @XmlElement(name = "FilmAdminID")
    private String adminId;
    @XmlElement(name = "Duration")
    private Long duration;
    @XmlElement(name = "Place")
    private String place;
    @XmlElementRef(name = "MultilingualList")
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
