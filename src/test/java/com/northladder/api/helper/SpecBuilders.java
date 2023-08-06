package com.northladder.api.helper;

/*import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;*/

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SpecBuilders {
    /**
     * This method creates the request specification based on the baseURI and basePth.
     * @param baseURI
     * @param basePth
     * @return The object of the RequestSpecification.
     */
//    @Step
    public static RequestSpecification requestSpecification(String baseURI, String basePth){

        return new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .log(LogDetail.ALL)
                .setBasePath(basePth).build();
 //               .addFilter(new AllureRestAssured()).build();

    }

    /**
     * This method creates the request specification based on the baseURI and as form url encoded.
     * @return The object of the RequestSpecification.
     */
 //   @Step
/*    public static RequestSpecification getAccountRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getInstance().getPropertyValue("Google_BASE_URI"))
                .setContentType(ContentType.URLENC)
 //               .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL)
                .build();
    }*/
    /**
     * This method creates the response specification.
     * @return The object of the ResponseSpecification.
     */

    public static ResponseSpecification responseSpecification(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

    }

    public static ResponseSpecification responseSpecificationHTML(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.HTML)
                .log(LogDetail.ALL)
                .build();

    }
}
