package com.test.api.helpers;

import com.test.api.pojo.zippopotam.ZippopotamRootPojo;
import com.test.commonutils.PropertyUtils;
import com.test.api.utils.APIPathConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestMethods {


    public static Response post(String basePath,String endPoint,Object requestBody){
        return given(Specbuilders.requestSpecification(System.getProperty("BASE_URI"),basePath))
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .log().all()
                .post(endPoint)
                .then().spec(Specbuilders.responseSpecification())
                .extract().response();

    }

    public static Response postWithPathParm(String basePath,String endPoint,String assetId, Object requestBody){
        return given(Specbuilders.requestSpecification(System.getProperty("BASE_URI"),basePath))
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .log().all()
                .post(endPoint,assetId)
                .then().spec(Specbuilders.responseSpecification())
                .extract().response();

    }

    public static Response getwithPathParm(String basePath,String endPoint,String assetInfoId){
        return given(Specbuilders.requestSpecification(System.getProperty("BASE_URI"),basePath)).
                when()
                .get(endPoint,assetInfoId).
                then()
                .contentType(ContentType.JSON)
                .spec(Specbuilders.responseSpecification()).log().all()
                .extract().response();

    }

    public static Response getwithPathParms(String basePath,String endPoint,String category,String brandId){
        return given(Specbuilders.requestSpecification(System.getProperty("BASE_URI"),basePath)).
                when().get(endPoint,category,brandId).
                then().spec(Specbuilders.responseSpecification())
                .extract().response();

    }


    public static Response getfulladdress(String basePath,String endPoint,String countryCode,String postalCode) {

        return given(Specbuilders.requestSpecification(APIPathConstants.ZIPPOPOTUM_BASE_URI, basePath))
                .pathParam("inbox_id", countryCode)
                .pathParam("messageID", postalCode)
                .when()
                .get(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .spec(Specbuilders.responseSpecification())
                .log().all()
                .extract()
                .response();
    }

    public static ZippopotamRootPojo getfulladdress(String basePath,String endPoint) {

        return given(Specbuilders.requestSpecification(APIPathConstants.ZIPPOPOTUM_BASE_URI, basePath))
                .when()
                .get(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .spec(Specbuilders.responseSpecification())
                .log().all()
                .extract()
                .as(ZippopotamRootPojo.class);

    }





}
