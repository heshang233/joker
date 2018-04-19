package com.joker.restful.util;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.*;
import java.time.Instant;

/**
 * @author huangsy
 * @date 2018/4/8 11:12
 */
@XmlRootElement(name="GetFilmListRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class GetFilmListRequestDTO {
    @XmlAttribute(name = "UserName")
    private String userName;
    @XmlAttribute(name = "Psw")
    private String password;
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

    public Instant getReportDate() {
        return reportDate;
    }

    public void setReportDate(Instant reportDate) {
        this.reportDate = reportDate;
    }
}
