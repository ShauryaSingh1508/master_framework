package com.test.commonutils;

import com.test.web.base.BaseTest;
import com.test.web.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;




    private ConfigLoader(){
        String env = BaseTest.envType;
        switch (EnvType.valueOf(env)) {
            case DEV -> properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
            case TEST -> properties = PropertyUtils.propertyLoader("src/test/resources/test_config.properties");
            case UAT -> properties = PropertyUtils.propertyLoader("src/test/resources/uat_config.properties");

            default -> throw new IllegalStateException("Invalid env type: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stg_config.properties file");
    }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if(prop != null) return prop;
        else throw new RuntimeException("property username is not specified in the stg_config.properties file");
    }


    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        else throw new RuntimeException("property password is not specified in the stg_config.properties file");
    }
}
