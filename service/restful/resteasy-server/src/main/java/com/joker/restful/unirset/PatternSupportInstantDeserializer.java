package com.joker.restful.unirset;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Created by lorin on 15/12/26.
 */
public class PatternSupportInstantDeserializer extends InstantDeserializer<Instant> {

    public static final PatternSupportInstantDeserializer INSTANCE = new PatternSupportInstantDeserializer
            (InstantDeserializer.INSTANT, DateTimeFormatter.ISO_INSTANT);

    protected PatternSupportInstantDeserializer(InstantDeserializer<Instant> base, DateTimeFormatter f) {
        super(base, f);
    }

    @Override
    public JsonDeserializer<Instant> withDateFormat(DateTimeFormatter dtf) {
        return super.withDateFormat(dtf);
    }

}
