package com.northladder.commonutils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static <T> T deserializeJson(String fileName, Class<T> T) throws IOException {

        ObjectMapper objectMapper;

            objectMapper = new ObjectMapper();
            InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
            return objectMapper.readValue(is, T);
    }
}

