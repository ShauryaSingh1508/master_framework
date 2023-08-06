package com.northladder.api.helper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.apache.commons.lang3.StringEscapeUtils;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonMethods {

    private static String basePath;
    private static String endPoint;
    static int brandIndex = 0;
    static List<String> refPropertykey = new ArrayList<>();
    String propertykey;
    static List<String> actualPropertykeys = new ArrayList<>();
    static JsonPath jsonPath;
    static String value;
    static int intvalue;

    /**
     * This is the constructor of the CommonMethods class.
     * @param basePath
     * @param endPoint
     */
    public CommonMethods(String basePath, String endPoint) {
        CommonMethods.basePath = basePath;
        CommonMethods.endPoint = endPoint;
    }

    public CommonMethods() {
    }


    /**
     * This method is called when the test cases are executed in parallel.
     * @param m
     */
//    @BeforeMethod
//    public void threadCount(Method m) {
//        System.out.println("----------------STARTING THE TEST:---------------->    " + m.getName());
//        System.out.println("---------------- THREAD COUNT IS :---------------->    " + Thread.currentThread().getId());
//
//
//    }

    /**
     * This method get the json response and set it as part of the object of the CommonMethods class
     */
 //   @Step
    public static void getJSONPath() {
        jsonPath = RestMethods.get(basePath, endPoint).jsonPath();
        System.out.println("The JSON path is " + jsonPath);



    }

    /**
     *
     * @return The Response body of the get request.
     */
  //  @Step
    public static ResponseBody getJSONPaths() {

        ResponseBody responseBody = RestMethods.get(basePath, endPoint).body();
        System.out.println("The JSON path is " + jsonPath);
        return responseBody;


    }

 //   @Step
    public static void getJSONPathWithParam(String assetInfoId) {
        jsonPath = RestMethods.getwithPathParm(basePath, endPoint, assetInfoId).jsonPath();
        System.out.println("The JSON path with params is " + jsonPath);

    }


//    @Step
    public static void getJSONPathWithParams(String category, String brandId) {
        jsonPath = RestMethods.getwithPathParms(basePath, endPoint, category, brandId).jsonPath();
        System.out.println("The JSON path with params is " + jsonPath);

    }

    public static void getJSONPathForMailTrap(String inbox_id) {
        jsonPath = RestMethods.getmailTrapapi(basePath, endPoint, inbox_id).jsonPath();
        System.out.println("The JSON path with params is " + jsonPath);

    }

    public static void getJSONPathForMailTrap(String inbox_id,Long message_id) {
        jsonPath = RestMethods.getmailTrapapi(basePath, endPoint, inbox_id,message_id).jsonPath();
        System.out.println("The JSON path with params is " + jsonPath);

    }


 //   @Step
    public static void postJSONPath(Object requestBody) {

        jsonPath = RestMethods.post(basePath, endPoint, requestBody).jsonPath();
        // System.out.println("The JSON path is " + jsonPath.prettyPrint());

    }

    /**
     * This method takes the json object of the request body generated and posts the same.
     * @param requestBody
     * @return To return the response body.
     */
 //   @Step
    public static ResponseBody postJSONPathAsObject(Object requestBody) {

        return RestMethods.post(basePath, endPoint, requestBody).body();


    }
    /**
     * This method takes the json object of the request body generated and posts the same.
     * @param requestBody
     * @return To return the response body.postJSONPathRequestWithToken
     */
//    @Step
    public static ResponseBody postJSONPathRequestWithToken(String token, Object requestBody) {
        return RestMethods.postWithToken(basePath, endPoint,token, requestBody).body();



    }


 //   @Step
    public static void postJSONPathWithParam(String assetId, Object requestBody) {
        jsonPath = RestMethods.postWithPathParm(basePath, endPoint, assetId, requestBody).jsonPath();
        System.out.println("The JSON path with params is " + jsonPath);

    }

    /**
     * This method takes the parameter as the bidID and perform the delete action.
     * @param bidID
     * @return To return the response deleteJSONPathRequestWithToken
     */
 //   @Step
    public static ResponseBody deleteJSONPathRequestWithToken(String token, String bidID) {
        return RestMethods.deleteWithToken(basePath, endPoint,token, bidID).body();



    }


    /**
     * This method gets the list of the category names.
     * @return the list of all the Categories in refPropertykey.
     * @throws Exception
     */
    public static List<String> getCategoryName() throws Exception {
        try {
            refPropertykey = jsonPath.getList("data.categoryName");

        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key ");
        }
        return refPropertykey;

    }

    /**
     * This method compares the value of the propertyValue from the list of jsonPathofrefPropertykey to get the
     * value of the actualPropertykeys based on the index of the propertyValue.
     * @param propertyValue
     * @param jsonPathofrefPropertykey
     * @param jsonPathofActualPropertykey
     * @return The value of the property key.
     * @throws Exception
     */
    public static String getBrandCharacteristic(String propertyValue, String jsonPathofrefPropertykey, String jsonPathofActualPropertykey) throws Exception {
        try {

            refPropertykey = jsonPath.getList(jsonPathofrefPropertykey);
            actualPropertykeys = jsonPath.getList(jsonPathofActualPropertykey);

            for (String mobilePhoneBrand : refPropertykey) {
                if (mobilePhoneBrand.trim().equalsIgnoreCase(propertyValue)) {
                    brandIndex = refPropertykey.indexOf(mobilePhoneBrand);
                    value = actualPropertykeys.get(brandIndex);
                    break;
                }

            }
        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key " + propertyValue);
        }
        return value;

    }
    /**
     * This method compares the value of the propertyValue from the list of jsonPathofrefPropertykey to get the
     * value of the actualPropertykeys based on the index of the propertyValue.
     * @param propertyValue
     * @param jsonPathofrefPropertykey
     * @param jsonPathofActualPropertykey
     * @return The integer value of the property key.
     * @throws Exception
     */

    public static int getBrandCharacteristicint(String propertyValue, String jsonPathofrefPropertykey, String jsonPathofActualPropertykey) throws Exception {
        try {
            //getJSONPath();
            List<Integer> actualPropertykeys;
            refPropertykey = jsonPath.getList(jsonPathofrefPropertykey);
            actualPropertykeys = jsonPath.getList(jsonPathofActualPropertykey);

            for (String mobilePhoneBrand : refPropertykey) {
                if (mobilePhoneBrand.equalsIgnoreCase(propertyValue)) {
                    brandIndex = refPropertykey.indexOf(mobilePhoneBrand);
                    intvalue = actualPropertykeys.get(brandIndex);
                    break;
                }

            }
        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key " + propertyValue);
        }
        return intvalue;

    }

    /**
     * This method takes the propertyValue and compares from the jsonPathofrefPropertykey.
     * @param propertyValue
     * @param jsonPathofrefPropertykey
     * @return it returns the index of the json array.
     * @throws Exception
     */
    public static int getElementId(String propertyValue, String jsonPathofrefPropertykey) throws Exception {
        try {
            //getJSONPath();
            List<Integer> actualPropertykeys;
            refPropertykey = jsonPath.getList(jsonPathofrefPropertykey);
            for (String mobilePhoneBrand : refPropertykey) {
                if (mobilePhoneBrand.equalsIgnoreCase(propertyValue)) {
                    intvalue = refPropertykey.indexOf(mobilePhoneBrand);
                    break;
                }

            }
        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key " + propertyValue);
        }
        return intvalue;

    }

    /**
     * This method takes jsonPathofActualPropertykey as parameter and get the value.
     * @param jsonPathofActualPropertykey
     * @return The integer value of the property key.
     * @throws Exception
     */
//    @Step
    public static int getBrandCharacteristicint(String jsonPathofActualPropertykey) throws Exception {
        try {
            //getJSONPath();
            return jsonPath.get(jsonPathofActualPropertykey);

        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key " + e);
        }


    }
    /**
     * This method takes jsonPathofActualPropertykey as parameter and get the value.
     * @param jsonPathofActualPropertykey
     * @return The double value of the property key.
     * @throws Exception
     */
 //   @Step
    public static Number getBrandCharacteristicdouble(String jsonPathofActualPropertykey) throws Exception {
        try {
            //getJSONPath();
            return jsonPath.get(jsonPathofActualPropertykey);


        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key " + e);
        }


    }

    /**
     * This method takes jsonPathofActualPropertykey as parameter and get the value.
     * @param jsonPathofrefPropertykey
     * @return The String value of the property key.
     * @throws Exception
     */
//    @Step
    public static Long getBrandCharacteristic(String jsonPathofrefPropertykey) throws Exception {
        try {

            return jsonPath.get(jsonPathofrefPropertykey);

        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key ");
        }


    }

    public static String getBrandCharacteristic(String inbox_Id,Long messsage_Id) throws Exception {
        try {

        ResponseBody responseBody = RestMethods.getmailTrapapi(basePath,endPoint,inbox_Id,messsage_Id).getBody();
        System.out.println("The JSON path is "+ responseBody.asPrettyString());
        return responseBody.asPrettyString();

        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key ");
        }


    }

    private static String extractJsonFromHtml(String htmlResponse) {
        // Search for the JSON data within the HTML response using regular expressions
        Pattern pattern = Pattern.compile("<script type=\"application/json\">(.*?)</script>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(htmlResponse);

        if (matcher.find()) {
            // Get the matched JSON data
            String json = matcher.group(1);

            // Unescape any HTML entities in the JSON string
            String unescapedJson = StringEscapeUtils.unescapeHtml4(json);

            return unescapedJson;
        }

        return null; // JSON data not found in the HTML response
    }


}


