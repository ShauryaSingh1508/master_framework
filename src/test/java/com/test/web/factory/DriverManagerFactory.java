package com.test.web.factory;


import com.test.web.constants.DriverType;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType driverType){
        switch (driverType){
            case CHROME -> {
                return new ChromeDriverManager();
            }
            case FIREFOX -> {
                return new FirefoxDriverManager();
            }
            default -> throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
