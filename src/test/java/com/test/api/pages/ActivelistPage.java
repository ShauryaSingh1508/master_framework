package com.test.api.pages;

import com.test.api.helpers.CommonMethods;
import com.test.api.pojo.freequote.Assetlist;
import com.test.api.utils.APIPathConstants;
import io.qameta.allure.Step;


public class ActivelistPage extends CommonMethods {
    static Assetlist assetlist;

    public ActivelistPage(String basePath, String endPoint) {
        super(basePath, endPoint);
    }


    private static void activelistPageRequest() throws Exception {
        new ActivelistPage(APIPathConstants.BASE_PATH_ADMIN,APIPathConstants.CATAGORY+APIPathConstants.ACTIVELIST);
        CommonMethods.getJSONPath();
 //       assetlist = CommonMethods.getJSONPaths().as(Assetlist.class);

    }
    @Step
   public static String shouldReturnBrandId(String brandNme) throws Exception {
        activelistPageRequest();
        return CommonMethods.getBrandCharacteristic(brandNme,"data.brands[0].name","data.brands[0]._id");

    }

 /*   @Step
    public static String shouldReturnBrandIds(String categoryName,String brandNme) throws Exception {
        activelistPageRequest();
        String brandId = null;

        int value = CommonMethods.getBrandCharacteristics(assetlist.getData(),categoryName);
        for(int brandname = 0;brandname<assetlist.getData().get(value).getBrands().size();brandname++){
            if(brandNme.equalsIgnoreCase(assetlist.getData().get(value).getBrands().get(brandname).getName())){
                brandId = assetlist.getData().get(value).getBrands().get(brandname).getId();
                break;
            }
        }
        return  brandId;
      }*/

    @Step
    public static String shouldReturnCategoryId(String categoryName) throws Exception {
        activelistPageRequest();
      /*  int value = CommonMethods.getBrandCharacteristics(assetlist.getData(),categoryName);
        return assetlist.getData().get(value).getId();
*/

        return CommonMethods.getBrandCharacteristic(categoryName,"data.categoryName","data._id");


    }

    @Step
    public static String shouldReturnCategoryType(String categoryName) throws Exception {
        activelistPageRequest();
        return CommonMethods.getBrandCharacteristic(categoryName,"data.categoryName","data.type");


    }

    @Step
    public static String shouldReturnFeeStructureId() throws Exception {
        activelistPageRequest();
        return String.valueOf(CommonMethods.getBrandCharacteristic("data[0].feeStructureId"));


    }


}
