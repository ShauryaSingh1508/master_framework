package com.test.api.utils;

import java.util.Properties;

public class ConfigReader {

    private final Properties properties;
    private static ConfigReader configReader;

    private ConfigReader(){
        properties = PropertyReader.propertyReader(System.getProperty("user.dir")+"/src/test/resources/config.properties");
    }

    public static ConfigReader getInstance(){
        if(configReader == null){
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getPropertyValue(String property){
        String prop = properties.getProperty(property);
        if(prop != null) return prop;
        else throw new RuntimeException("Property type "+ property+" is missing in "+ PropertyReader.class.getSimpleName());
    }




}
