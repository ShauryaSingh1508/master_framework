package com.test.api.helpers;

import com.test.api.pojo.zippopotam.ZippopotamRootPojo;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
    //static ZippopotamRootPojo  zippopotamRootPojo;

    public CommonMethods(String basePath, String endPoint) {
        CommonMethods.basePath = basePath;
        CommonMethods.endPoint = endPoint;
    }


    @BeforeMethod
    public void threadCount(Method m) {
        System.out.println("----------------STARTING THE TEST:---------------->    " + m.getName());
        System.out.println("---------------- THREAD COUNT IS :---------------->    " + Thread.currentThread().getId());


    }

    @Step
    public static void getJSONPath() {
        jsonPath = RestMethods.get(basePath, endPoint).jsonPath();
        System.out.println("The JSON path is " + jsonPath);
/*        ResponseBody responseBody = RestMethods.get(basePath,endPoint).getBody();
        System.out.println("The JSON path is "+ jsonPath);
        return responseBody;*/


    }
    @Step
    public static ZippopotamRootPojo getZippopotamResponse() {
        return RestMethods.getfulladdress(basePath, endPoint);
    }
    @Step
    public static ResponseBody getJSONPaths() {

       ResponseBody responseBody = RestMethods.get(basePath,endPoint).body();
        System.out.println("The JSON path is "+ jsonPath);
        return responseBody;


    }

    @Step
    public static void getJSONPathWithParam(String assetInfoId) {
        jsonPath = RestMethods.getwithPathParm(basePath, endPoint, assetInfoId).jsonPath();
        System.out.println("The JSON path with params is " + jsonPath);

    }

    @Step
    public static void getJSONPathWithParams(String category, String brandId) {
        jsonPath = RestMethods.getwithPathParms(basePath, endPoint, category, brandId).jsonPath();
        System.out.println("The JSON path with params is " + jsonPath);

    }


    @Step
    public static void getJSONPathWithQueryParam(String paramName) {
        jsonPath = RestMethods.getwithPathParm(basePath, endPoint, paramName).jsonPath();
        System.out.println("The JSON path with params is " + jsonPath);

    }

    @Step
    public static void postJSONPath(Object requestBody) {
        //Freequote freequote = RestMethods.post(basePath,endPoint,requestBody).as(Freequote.class);
        jsonPath = RestMethods.post(basePath, endPoint, requestBody).jsonPath();
        System.out.println("The JSON path is " + jsonPath.prettyPrint());

    }


    @Step
    public static void postJSONPathWithParam(String assetId, Object requestBody) {
        jsonPath = RestMethods.postWithPathParm(basePath, endPoint, assetId, requestBody).jsonPath();
        System.out.println("The JSON path with params is " + jsonPath);

    }


    public static String getBrandCharacteristic(String propertyValue, String jsonPathofrefPropertykey, String jsonPathofActualPropertykey) throws Exception {
        try {
            //getJSONPath();

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

/*    public static int getBrandCharacteristics(List<Datum> propertyValue, String jsonPathofrefPropertykey) throws Exception {
        int value;
        try {
            //getJSONPath();

            for ( value = 0; value <= propertyValue.size(); value++) {
                if (propertyValue.get(value).getCategoryName().equalsIgnoreCase(jsonPathofrefPropertykey))
                {
                 break;

                }



            }

        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key " + propertyValue);
        }

        return value;
    }*/

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

    @Step
    public static int getBrandCharacteristicint(String jsonPathofActualPropertykey) throws Exception {
        try {
            //getJSONPath();
            return jsonPath.get(jsonPathofActualPropertykey);

        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key " + e);
        }


    }

    @Step
    public static Number getBrandCharacteristicdouble(String jsonPathofActualPropertykey) throws Exception {
        try {
            //getJSONPath();
            return jsonPath.get(jsonPathofActualPropertykey);


        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key " + e);
        }


    }

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
    public static void getJSONPathForMailTrap(String inbox_id) {
        jsonPath = RestMethods.getmailTrapapi(basePath, endPoint, inbox_id).jsonPath();
        //System.out.println("The JSON path with params is " + jsonPath);

    }

    public static void getJSONPathForMailTrap(String inbox_id,Long message_id) {
        jsonPath = RestMethods.getmailTrapapi(basePath, endPoint, inbox_id,message_id).jsonPath();
        System.out.println("The JSON path with params is " + jsonPath);

    }

    public static String getJsonElement(String jsonPathofrefPropertykey) throws Exception {
        try {

            return jsonPath.get(jsonPathofrefPropertykey);

        } catch (Exception e) {

            throw new Exception("Unable to get the value of the property key ");
        }


    }


}
