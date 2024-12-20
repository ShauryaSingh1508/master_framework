package com.test.api.pages;

import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class TestRunner {


 /*   @Test
    public void getassetId() throws Exception {

        ItemCondition itemCondition = new ItemCondition("OnePlus","Mobile Phones","OnePlus 7 Series","OnePlus 7T Pro 5G McLaren","256 GB","12 GB");
        Integer conditionpercent = itemCondition.getpercentValue("Brand New");
        System.out.println(conditionpercent);
        String conditionId = itemCondition.getassetConditionId("Brand New");
        System.out.println(conditionId);
        String conditionDescription = itemCondition.getconditionDescription("Brand New");
        System.out.println(conditionDescription);

    }
*/
   /* @Test
    public void createFreequote() throws Exception {

        String freequoteID = FreequoteAPI.getFreequoteId();
        System.out.println(freequoteID);
    }*/
/*    @Test
     public void getStoreId() throws Exception {

         String memberId = StorageMembers.getgetStorageMemberid("OnePlus","Mobile Phones","OnePlus 7 Series","OnePlus 7T Pro 5G McLaren","256 GB","12 GB");
         System.out.println(memberId);


         condition,brandName,categoryName,date,assetSeries,brandVersion,storage,ram,email
         assetSeries,brandVersion,storage,ram,email

         }*/
/*    @Story("Final Story of Appraisal")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @TmsLink("")
    @Issue("")
    @Test(description = "Should be able to create an appraisal")
    public void createReverseAppraisal() throws Exception {

        String reverseAppraisalCode = ReversAuctionAPI.getAppraisalCode("Dar Al Salam Mobile Phones","Flawless","OnePlus","Mobile Phones",
                                                                    "2022-2-1","OnePlus 7 Series","OnePlus 7T Pro 5G McLaren"
                                                                        ,"256 GB","12 GB","test@gmail.com","Shaurya", "1234567890");
        System.out.println(reverseAppraisalCode);
    }*/
/*
     @Story("Final Story of Appraisal")
     @Link("https://example.org")
     @Link(name = "allure", type = "mylink")
     @TmsLink("")
     @Issue("")
    @Test(description = "Should be able to create an Active asset Attribute")
    public void creategetAssetConfigId() throws Exception {

        String reverseAppraisalCode = new ActiveAssetAttributes("OnePlus","Mobile Phones","OnePlus 7 Series").getAssetConfigId("OnePlus 7T Pro 5G McLaren","256 GB","12 GB");
        System.out.println(reverseAppraisalCode);
    }
*/
     @Story("Final Story of Appraisal")
     @Link("https://example.org")
     @Link(name = "allure", type = "mylink")
     @TmsLink("")
     @Issue("")
     @Test(description = "Should be able to create an Active asset Attribute")
     public void creategetAssetConfigId() throws Exception {

         String AssetId = ActivelistPage.shouldReturnCategoryId("OnePlus");
         System.out.println(AssetId);


     }

/*    @Test
    public void getResponse() throws JSONException {
        RestAssured.baseURI = "https://nl-apidev.asancash.com/";
        RequestSpecification requestSpecification = RestAssured.given();
        JSONObject jsonObjectParent = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonModel = new JSONObject();
        JSONObject jsonStorage = new JSONObject();
        JSONObject jsonRam = new JSONObject();

      *//* jsonObject.put("key","Model");
        jsonObject.put("key","Storage");
        jsonObject.put("key","RAM");*//*
        jsonModel.put("key","Model");
        jsonModel.put("value","OnePlus 7T Pro 5G McLaren");

        jsonStorage.put("key","Storage");
        jsonStorage.put("value","256 GB");

        jsonRam.put("key","RAM");
        jsonRam.put("value","12 GB");

        jsonArray.put(jsonModel);
        jsonArray.put(jsonStorage);
        jsonArray.put(jsonRam);
        jsonObjectParent.put("attributes",jsonArray);

        System.out.println(jsonObjectParent);
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body(jsonObjectParent.toString());
        Response response = requestSpecification.request(Method.POST,"as/assets/active-asset-attributes/5fb3a3a5b0ae1b0019f82c3e");
        System.out.println(response.asPrettyString());
    }*/

}
