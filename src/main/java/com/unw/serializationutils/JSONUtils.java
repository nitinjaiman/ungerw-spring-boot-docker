package com.unw.serializationutils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.unw.serializationutils.exceptions.SerializationException;

import java.io.File;
import java.io.IOException;

public class JSONUtils {
    private ObjectMapper mapper = new ObjectMapper();
    private static JSONUtils instance;

    private JSONUtils() {
        this.mapper.configure(SerializationFeature.INDENT_OUTPUT, false);
        this.mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static JSONUtils getInstance() {
        if (null == instance) {
            synchronized (JSONUtils.class) {
                if (null == instance) {
                    instance = new JSONUtils();
                }
            }
        }
        return instance;
    }

    public <T> T getObject(String json, Class<T> className) {
        try {
            return this.mapper.readValue(json, className);
        } catch (IOException e) {
            throw new SerializationException("Exception while parsing JSON String", e);
        }
    }

    public String getJson(Object object) {
        try {
            return this.mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Exception while parsing object", e);
        }
    }

    public <T> T getObject(String json, TypeReference<T> typeReference) {
        try {
            return this.mapper.readValue(json, typeReference);
        } catch (IOException e) {
            throw new SerializationException("Exception while parsing JSON String", e);
        }
    }

    public <T> T getObjectFromJSONFile(File jsonFile, Class<T> className) {
        try {
            return this.mapper.readValue(jsonFile, className);
        } catch (IOException e) {
            throw new SerializationException("Exception while parsing JSON from JSONFile", e);
        }
    }

    public <T> T getObjectFromJSONFile(File jsonFile, TypeReference<T> typeReference) {
        try {
            return this.mapper.readValue(jsonFile, typeReference);
        } catch (IOException e) {
            throw new SerializationException("Exception while parsing JSON from JSONFile", e);
        }
    }
}
