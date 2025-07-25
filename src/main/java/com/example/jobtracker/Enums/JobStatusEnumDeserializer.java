package com.example.jobtracker.Enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class JobStatusEnumDeserializer extends JsonDeserializer<JobStatusEnum> {
    @Override
    public JobStatusEnum deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, IOException {
        String value = p.getText();
        try {
            return JobStatusEnum.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IOException("Invalid JobStatusEnum value: " + value);
        }
    }
}
