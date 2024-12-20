package com.test.api.pages;

import com.test.api.helpers.CommonMethods;
import com.test.api.utils.APIPathConstants;
import io.qameta.allure.Step;

public class AssetGroups {

    CommonMethods commonMethods;
    String brandId;
    String CategoryId;


    AssetGroups(String brandNme, String categoryName) throws Exception {
        try {
            brandId = ActivelistPage.shouldReturnBrandId(brandNme);
            CategoryId = ActivelistPage.shouldReturnCategoryId(categoryName);
            new CommonMethods(APIPathConstants.BASE_PATH_ADMIN,
                        APIPathConstants.ASSETS+APIPathConstants.ACTIVEGROUPS+"/{CategoryId}"+"/{brandId}");
           CommonMethods.getJSONPathWithParams(CategoryId,brandId);
        } catch (Exception e) {
            throw new Exception("Not able to get the url with the category id "+CategoryId +" and "+brandId);
        }

    }


    @Step
    public String shouldReturnAssetSeriesId(String assetSeries) throws Exception {
        return CommonMethods.getBrandCharacteristic(assetSeries,"data.name","data._id");

    }







}
