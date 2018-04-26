package com.resteasy.springboot.domain.response;

/**
 * @author huangsy
 * @date 2018/4/26 14:04
 */
public class FilmList {
    private String uuid;
    private String name;
    private String file_name;

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

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}
