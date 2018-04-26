package com.resteasy.springboot.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author huangsy
 * @date 2018/4/16 8:45
 */
@XmlRootElement(name="MultilingualList")
@XmlAccessorType(XmlAccessType.NONE)
public class MultilingualListDTO {
    @XmlAttribute(name = "LanguageCount")
    @JsonProperty("language_count")
    private int languageCount = 3;
    @XmlElementRef(name = "Multilingual")
    @JsonProperty("multilinguals")
    private List<MultilingualDTO> multilingualDTO;

    public int getLanguageCount() {
        return languageCount;
    }

    public void setLanguageCount(int languageCount) {
        this.languageCount = languageCount;
    }

    public List<MultilingualDTO> getMultilingualDTO() {
        return multilingualDTO;
    }

    public void setMultilingualDTO(List<MultilingualDTO> multilingualDTO) {
        this.multilingualDTO = multilingualDTO;
    }
}
