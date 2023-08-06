package com.northladder.api.base;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class BaseTestApi {

    static String envType;

    @Parameters("mail")
    @BeforeMethod
    public synchronized void readFilePath(@Optional String mail){
        envType = System.getProperty("mail", mail);

    }

//    /**
//     * This method is called when the test cases are executed in parallel.
//     * @param m
//     */
//    @BeforeMethod
//    public void threadCount(Method m) {
//        System.out.println("----------------STARTING THE TEST:---------------->    " + m.getName());
//        System.out.println("---------------- THREAD COUNT IS :---------------->    " + Thread.currentThread().getId());
//
//
//    }
}
