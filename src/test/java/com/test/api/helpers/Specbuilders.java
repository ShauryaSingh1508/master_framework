package com.test.api.helpers;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specbuilders {


    public static RequestSpecification requestSpecification(String baseURI,String basePth){

        return new RequestSpecBuilder().setBaseUri(baseURI).
                setBasePath(basePth).addFilter(new AllureRestAssured()).log(LogDetail.ALL).build();

    }

    public static ResponseSpecification responseSpecification(){
        return new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

    }
    public static ResponseSpecification responseSpecificationHTML(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.HTML)
                .log(LogDetail.ALL)
                .build();

    }
}
