package com.test.api.pages;

import com.test.api.helpers.CommonMethods;
import com.test.api.utils.APIPathConstants;
import io.qameta.allure.Step;

public class FeeStructure extends CommonMethods {

    public FeeStructure(String basePath, String endPoint) throws Exception {
        super(basePath, endPoint);
        CommonMethods.getJSONPathWithParam(ActivelistPage.shouldReturnFeeStructureId());
    }

    private static void PageRequest() throws Exception {
        new FeeStructure(APIPathConstants.BASE_PATH_ADMIN,APIPathConstants.CATAGORY+APIPathConstants.ACTIVELIST);
        CommonMethods.getJSONPath();

    }
   /* @Step
    public static String shouldgetSellValue() throws Exception {
        PageRequest();
        return CommonMethods.getBrandCharacteristic("data.sellValue");


    }
    @Step
    public static String shouldgetTaxRate() throws Exception {
        PageRequest();
        return CommonMethods.getBrandCharacteristic("data.taxRate");


    }

    @Step
    public static String shouldgetStorageFee() throws Exception {
        PageRequest();
        return CommonMethods.getBrandCharacteristic("data.taxRate");


    }*/




}
