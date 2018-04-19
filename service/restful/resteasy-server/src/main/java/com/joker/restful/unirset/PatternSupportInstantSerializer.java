package com.joker.restful.unirset;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializerBase;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Created by lorin on 15/12/26.
 */
public class PatternSupportInstantSerializer extends InstantSerializerBase<Instant> {

    public static final PatternSupportInstantSerializer INSTANCE = new PatternSupportInstantSerializer();
    private static final long serialVersionUID = 1L;

    protected PatternSupportInstantSerializer() {
        super(Instant.class, Instant::toEpochMilli, Instant::getEpochSecond, Instant::getNano, null);
    }

    public PatternSupportInstantSerializer(InstantSerializerBase<Instant> base, Boolean useTimestamp,
                                           DateTimeFormatter dtf) {
        super(base, useTimestamp, dtf);
    }

    @Override
    public InstantSerializerBase withFormat(Boolean useTimestamp, DateTimeFormatter dtf, JsonFormat.Shape shape) {
        return new PatternSupportInstantSerializer(this, useTimestamp, dtf);
    }

}
