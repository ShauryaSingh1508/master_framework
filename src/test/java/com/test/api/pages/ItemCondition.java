package com.test.api.pages;

import com.test.api.helpers.CommonMethods;
import com.test.api.utils.APIPathConstants;
import io.qameta.allure.Step;

public class ItemCondition extends CommonMethods {


    public ItemCondition(String basePath, String endPoint) {
        super(basePath, endPoint);
    }

    private static void itemConditionPageRequest(String brandNme, String categoryName,String assetSeries,String brandVersion,String storage,String ram) throws Exception {
        String assetInfoId = new ActiveAssetAttributes(brandNme,categoryName,assetSeries).getAssetConfigId(brandVersion,storage,ram);
        {
            new ItemCondition(APIPathConstants.BASE_PATH_ADMIN,
                    APIPathConstants.V3+APIPathConstants.CONFIGURATION+
                            APIPathConstants.ITEMCONDITION+APIPathConstants.INFO+"/{assetInfoId}");
            CommonMethods.getJSONPathWithParam(assetInfoId);
        }

    }

/*    ItemCondition(String brandNme, String categoryName,String assetSeries,String brandVersion,String storage,String ram) throws Exception {
        super();


        String assetInfoId = new ActiveAssetAttributes(brandNme,categoryName,assetSeries).getAssetConfigId(brandVersion,storage,ram);
        {
            commonMethods = new CommonMethods(APIPathConstants.BASE_PATH_ADMIN,
                    APIPathConstants.V3+APIPathConstants.CONFIGURATION+
                            APIPathConstants.ITEMCONDITION+APIPathConstants.INFO+"/{assetInfoId}");
            commonMethods.getJSONPathWithParam(assetInfoId);
        }


    }*/

    @Step
    public static String getassetConditionId(String condition) throws Exception {
        return CommonMethods.getBrandCharacteristic(condition,"data.conditions.condition","data.conditions._id");

    }

    @Step
    public static int getpercentValue(String condition, String brandName, String categoryName, String assetSeries, String brandVersion, String storage, String ram) throws Exception {
        itemConditionPageRequest(brandName,categoryName,assetSeries,brandVersion,storage,ram);
        return CommonMethods.getBrandCharacteristicint(condition,"data.conditions.condition","data.conditions.percentValue");

    }



    public static String getconditionDescription(String condition) throws Exception {
        return CommonMethods.getBrandCharacteristic(condition,"data.conditions.condition","data.conditions.description");

    }
}
