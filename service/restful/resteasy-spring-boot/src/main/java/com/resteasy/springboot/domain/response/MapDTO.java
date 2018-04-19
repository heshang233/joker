package com.resteasy.springboot.domain.response;

/**
 * @author huangsy
 * @date 2018/4/19 11:13
 */
public class MapDTO {

    private FilmInfoDTO filmInfoDTO;

    private FilmFtpDTO filmFtpDTO;

    public FilmInfoDTO getFilmInfoDTO() {
        return filmInfoDTO;
    }

    public void setFilmInfoDTO(FilmInfoDTO filmInfoDTO) {
        this.filmInfoDTO = filmInfoDTO;
    }

    public FilmFtpDTO getFilmFtpDTO() {
        return filmFtpDTO;
    }

    public void setFilmFtpDTO(FilmFtpDTO filmFtpDTO) {
        this.filmFtpDTO = filmFtpDTO;
    }
}
