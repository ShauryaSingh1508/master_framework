package com.test.commonutils;

import com.github.javafaker.Faker;
public class FakerUtils {

    public Long generateRandomNumber(){
        Faker faker = new Faker();
        return faker.number().randomNumber(10, true);
    }
}
