package com.northladder.api.helper;

import com.northladder.api.utils.APIPathConstants;
import com.northladder.commonutils.PropertyUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestMethods {

    /**
     * This method posts the request based on the basepath, endpoint and request body.
     * @param basePath
     * @param endPoint
     * @param requestBody
     * @return The Response and logs all the response in the log file.
     */
//    @Step
    public static Response post(String basePath, String endPoint, Object requestBody){
        return given(SpecBuilders.requestSpecification(System.getProperty("BASE_URI"),basePath))
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .log().all()
                .post(endPoint)
                .then().spec(SpecBuilders.responseSpecification())
                .extract()
                .response();

    }
    /**
     * This method posts the request based on the basepath, endpoint, token and request body.
     * @param basePath
     * @param endPoint
     * @param requestBody
     * @return The Response and logs all the response in the log file.
     */
//    @Step
    public static Response  postWithToken(String basePath,String endPoint, String token, Object requestBody){
        return given(SpecBuilders.requestSpecification(System.getProperty("BASE_URI"),basePath))
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .log().all()
                .auth().oauth2(token)
                .post(endPoint)
                .then().spec(SpecBuilders.responseSpecification())
                .extract()
                .response();
    }
    /**
     * This method posts the request based on the basepath, endpoint, path param and request body.
     * @param basePath
     * @param endPoint
     * @param requestBody
     * @return The Response and logs all the response in the log file.
     */
//    @Step
    public static Response postWithPathParm(String basePath,String endPoint,String assetId, Object requestBody){
        return given(SpecBuilders.requestSpecification(System.getProperty("BASE_URI"),basePath))
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .log().all()
                .post(endPoint,assetId)
                .then().spec(SpecBuilders.responseSpecification())
                .extract()
                .response();

    }

    /**
     * This method posts the request based on the hashmap of the formParams.
     * @param formParams
     * @return The Response and logs all the response in the log file.
     */
//    @Step
/*    public static Response postAccount(HashMap<String, String> formParams){
        return given(SpecBuilders.getAccountRequestSpec()).formParams(formParams)
                .when()
                .post(APIPathConstants.O+APIPathConstants.OAUTH+ APIPathConstants.TOKEN)
                .then()
                .spec(SpecBuilders.responseSpecification())
                .extract()
                .response();
    }*/

    /**
     * This method get the request based on the basePath and endPoint.
     * @param basePath
     * @param endPoint
     * @return
     */
//    @Step
    public static Response get(String basePath,String endPoint){
        return given(SpecBuilders.requestSpecification(APIPathConstants.MAILTRAP_BASE_URI,basePath))
                .when()
                .get(endPoint)
                .then()
                .spec(SpecBuilders.responseSpecification())
                .extract()
                .response();

    }
    /**
     * This method get the request based on the basepath, endpoint and path param.
     * @param basePath
     * @param endPoint
     * @return The Response and logs all the response in the log file.
     */
//    @Step
    public static Response getwithPathParm(String basePath,String endPoint,String assetInfoId){
        return given(SpecBuilders.requestSpecification(System.getProperty("BASE_URI"),basePath))
                .when()
                .get(endPoint,assetInfoId)
                .then()
                .contentType(ContentType.JSON)
                .spec(SpecBuilders.responseSpecification())
                .log().all()
                .extract()
                .response();

    }

    public static Response getmailTrapapi(String basePath,String endPoint,String inbox_Id){
        final Properties properties;
        properties = PropertyUtils.propertyLoader(System.getProperty("user.dir")+"/src/test/resources/config.properties");
        return given(SpecBuilders.requestSpecification(APIPathConstants.MAILTRAP_BASE_URI,basePath))
                .pathParam("inbox_id",inbox_Id)
                .queryParam("search",properties.getProperty("search"))
                .queryParam("page",properties.getProperty("page"))
                .header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJkYXRhIjp7InRva2VuIjoiNzUyOTcxYjlmNTk5NzBkODRkNDExMTI0OTVmN2E2ZGQifX0.e50ckikxipAE-wS4CE72SdsvBbWUWpdLakeZoeGZPUlNR4OJmzErn7XiJMNdXNTxEEEsZa3u-Wb4sno3gCBn9w")
                .when()
                .get(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .spec(SpecBuilders.responseSpecification())
                .log().all()
                .extract()
                .response();

    }

    public static Response getmailTrapapi(String basePath,String endPoint,String inbox_Id,Long messsage_Id){
        final Properties properties;
        properties = PropertyUtils.propertyLoader(System.getProperty("user.dir")+"/src/test/resources/config.properties");
        return given(SpecBuilders.requestSpecification(APIPathConstants.MAILTRAP_BASE_URI,basePath))
                .pathParam("inbox_id",inbox_Id)
                .pathParam("messageID", messsage_Id)
                .header("Authorization",properties.getProperty("Mailtraptoken"))
                .when()
                .get(endPoint)
                .then()
                .contentType(ContentType.HTML)
                .spec(SpecBuilders.responseSpecificationHTML())
                .log().all()
                .extract()
                .response();

    }

    /**
     * This method get the request based on the basepath, endpoint and multiple path params.
     * @param basePath
     * @param endPoint
     * @param category
     * @param brandId
     * @return The Response and logs all the response in the log file.
     */
 //   @Step
    public static Response getwithPathParms(String basePath,String endPoint,String category,String brandId){
        return given(SpecBuilders.requestSpecification(System.getProperty("BASE_URI"),basePath))
                .when()
                .get(endPoint,category,brandId)
                .then()
                .spec(SpecBuilders.responseSpecification())
                .extract()
                .response();

    }

    /**
     * This method put the request based on the basepath, endpoint, token and request body.
     * @param basePath
     * @param endPoint
     * @param token
     * @param requestBody
     * @return The updated response and logs all the response in the log file.
     */
//    @Step
    public static Response update(String basePath,String endPoint, String token, Object requestBody){
        return given(SpecBuilders.requestSpecification(System.getProperty("BASE_URI"),basePath))
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .log().all()
                .auth().oauth2(token)
                .put(endPoint)
                .then()
                .spec(SpecBuilders.responseSpecification())
                .extract()
                .response();
    }

//    @Step
    public static Response deleteWithToken(String basePath,String endPoint,String token,String bidID){
        return given(SpecBuilders.requestSpecification(System.getProperty("BASE_URI"),basePath))
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .auth().oauth2(token)
                .delete(endPoint,bidID)
                .then().spec(SpecBuilders.responseSpecification())
                .extract()
                .response();
    }


}
