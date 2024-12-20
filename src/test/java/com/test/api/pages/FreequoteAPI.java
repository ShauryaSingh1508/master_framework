package com.test.api.pages;

import com.test.api.helpers.CommonMethods;
import com.test.api.pojo.freequote.Condition;
import com.test.api.pojo.freequote.Freequote;
import com.test.api.utils.APIPathConstants;
import io.qameta.allure.Step;

public class FreequoteAPI extends CommonMethods {

    static Freequote requestBody;

    public FreequoteAPI(String basePath, String endPoint) {
        super(basePath, endPoint);
    }

    public static void createfreequote(String condition, String brandName, String categoryName, String date, String assetSeries, String brandVersion, String storage, String ram, String email) throws Exception {

        requestBody = Freequote.builder().brandName(brandName).
                brandId(ActivelistPage.shouldReturnBrandId(brandName)).
                categoryId(ActivelistPage.shouldReturnCategoryId(categoryName)).isSellAsset(true).
                responseToken("dummyvalue").buyBackTimeStamp(date).categoryName(categoryName).
                categoryType(ActivelistPage.shouldReturnCategoryType(categoryName)).
                assetId(new ActiveAssetAttributes(brandName, categoryName, assetSeries).
                        getAssetConfigId(brandVersion, storage, ram)).
                assetName(assetSeries).
                condition(createcondition(condition, brandName, categoryName, assetSeries, brandVersion, storage, ram)).
                email(email).build();

    }

    @Step
    public static Condition createcondition(String condition, String brandName, String categoryName, String assetSeries, String brandVersion, String storage, String ram) throws Exception {
        return Condition.builder().percentValue(ItemCondition.getpercentValue(condition, brandName, categoryName, assetSeries, brandVersion, storage, ram))
                .condition(condition).id(ItemCondition.getassetConditionId(condition))
                .description(ItemCondition.getconditionDescription(condition)).build();
    }

    @Step
    private static void postFreeQuoteAPI(String condition, String brandName, String categoryName, String date, String assetSeries, String brandVersion, String storage, String ram, String email) throws Exception {
        createfreequote(condition, brandName, categoryName, date, assetSeries, brandVersion, storage, ram, email);
        new FreequoteAPI(APIPathConstants.BASE_PATH_CUSTOMER,
                APIPathConstants.BASE_PATH_APRAISAL +
                        APIPathConstants.BASE_PATH_FREEQUOTE);
        CommonMethods.postJSONPath(requestBody);

    }

    @Step
    public static String getFreequoteId(String condition, String brandName, String categoryName, String date, String assetSeries, String brandVersion, String storage, String ram, String email) throws Exception {
        postFreeQuoteAPI(condition, brandName, categoryName, date, assetSeries, brandVersion, storage, ram, email);
        return String.valueOf(CommonMethods.getBrandCharacteristic("data.freeQuoteId"));

    }

    @Step
    public static String getApprovedAmount(String condition, String brandName, String categoryName, String date, String assetSeries, String brandVersion, String storage, String ram, String email) throws Exception {
        postFreeQuoteAPI(condition, brandName, categoryName, date, assetSeries, brandVersion, storage, ram, email);
        return String.valueOf(CommonMethods.getBrandCharacteristic("data.dealAmount.approvedAmount"));

    }

    @Step
    public static int getDealPrice(String condition, String brandName, String categoryName, String date, String assetSeries, String brandVersion, String storage, String ram, String email) throws Exception {
        postFreeQuoteAPI(condition, brandName, categoryName, date, assetSeries, brandVersion, storage, ram, email);
        return CommonMethods.getBrandCharacteristicint("data.sellAmount.dealPrice");

    }

    @Step
    public static int getDealPrice() throws Exception {
        return CommonMethods.getBrandCharacteristicint("data.sellAmount.dealPrice");

    }


    @Step
    public static Number getBbbServiceFee() throws Exception {
        return CommonMethods.getBrandCharacteristicdouble("data.sellAmount.sellbbbServiceFee");

    }

    @Step
    public static Number getBbbServiceFeeTax() throws Exception {
        return CommonMethods.getBrandCharacteristicdouble("data.sellAmount.sellbbbServiceFeeTax");

    }

    @Step
    public static int getSellAsseseeFee() throws Exception {
        return CommonMethods.getBrandCharacteristicint("data.sellAmount.sellstorageFee");

    }

    @Step
    public static int getSellstorageFeeTax() throws Exception {
        return CommonMethods.getBrandCharacteristicint("data.sellAmount.sellstorageFeeTax");

    }


    @Step
    public static Number getActualAmountBeforeRounding() throws Exception {
        return CommonMethods.getBrandCharacteristicdouble("data.sellAmount.actualSellAmount");

    }


    @Step
    public static int getActualAmountAfterAfterRounding() throws Exception {
        return CommonMethods.getBrandCharacteristicint("data.sellAmount.sellAmount");

    }


    @Step
    public static int getPercentValue() throws Exception {
        return CommonMethods.getBrandCharacteristicint("data.percentValue");

    }


}
