package com.resteasy.springboot.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author huangsy
 * @date 2018/4/3 15:00
 */
@XmlRootElement(name="FilmDCP")
@XmlAccessorType(XmlAccessType.NONE)
public class FilmFtpDTO{
    @XmlElement(name = "FilmUUID")
    @JsonProperty("uuid")
    private String uuid;
    @XmlElement(name = "FilmAdminID")
    @JsonProperty("admin_id")
    private String adminId = "test123";
    @XmlElement(name = "FilmName")
    @JsonProperty("name")
    private String name = "test321";
    @XmlElement(name = "DcpFtpPath")
    @JsonProperty("ftp_path")
    private String ftpPath;
    @XmlElement(name = "DcpUser")
    @JsonProperty("ftp_user")
    private String ftpUser;
    @XmlElement(name = "DcpPsw")
    @JsonProperty("ftp_psw")
    private String ftpPsw;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFtpPath() {
        return ftpPath;
    }

    public void setFtpPath(String ftpPath) {
        this.ftpPath = ftpPath;
    }

    public String getFtpUser() {
        return ftpUser;
    }

    public void setFtpUser(String ftpUser) {
        this.ftpUser = ftpUser;
    }

    public String getFtpPsw() {
        return ftpPsw;
    }

    public void setFtpPsw(String ftpPsw) {
        this.ftpPsw = ftpPsw;
    }
}
