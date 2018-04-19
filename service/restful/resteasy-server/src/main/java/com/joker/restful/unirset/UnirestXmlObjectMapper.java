package com.joker.restful.unirset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mashape.unirest.http.ObjectMapper;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author huangsy
 * @date 2018/4/10 17:31
 */
public class UnirestXmlObjectMapper implements ObjectMapper {
    private XmlMapper xmlMapper = new XmlMapper();
    private static final String FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_PATTERN).withZone(ZoneId
            .systemDefault());

    public UnirestXmlObjectMapper(){
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(Instant.class, PatternSupportInstantSerializer.INSTANCE.withFormat(false, dateTimeFormatter,null));
        module.addDeserializer(Instant.class, PatternSupportInstantDeserializer.INSTANCE.withDateFormat(dateTimeFormatter));
        xmlMapper.registerModule(module);
    }
    @Override
    public <T> T readValue(String value, Class<T> valueType) {
        try {
            return xmlMapper.readValue(value, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String writeValue(Object value) {
        try {
            return xmlMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
