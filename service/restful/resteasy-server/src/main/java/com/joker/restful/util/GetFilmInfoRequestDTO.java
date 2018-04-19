package com.joker.restful.util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.*;
import java.time.Instant;

/**
 * @author huangsy
 * @date 2018/4/8 11:15
 */
@XmlRootElement(name="GetFilmInfoRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class GetFilmInfoRequestDTO {
    @XmlAttribute(name = "UserName")
    private String userName;
    @XmlAttribute(name = "Psw")
    private String password;
    @XmlElement(name = "FilmUUID")
    private String uuid;
    private Instant reportDate = Instant.now();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Instant getReportDate() {
        return reportDate;
    }

    public void setReportDate(Instant reportDate) {
        this.reportDate = reportDate;
    }
}
