package com.test.api.pages;

import com.test.api.helpers.CommonMethods;
import com.test.api.utils.APIPathConstants;
import io.qameta.allure.Step;

public class StorageMembers extends CommonMethods {

    static StorageMembers storageMembers;
    static String storageMemberCountry;
    public StorageMembers(String basePath, String endPoint) {
        super(basePath, endPoint);
    }

    @Step
    private static void createStorageRequest(String brandNme, String categoryName,String assetSeries,String brandVersion,String storage,String ram) throws Exception {
        String assetInfoId = new ActiveAssetAttributes(brandNme,categoryName,assetSeries).getAssetConfigId(brandVersion,storage,ram);
        storageMembers= new StorageMembers(APIPathConstants.BASE_PATH_ADMIN,APIPathConstants.BIDS+APIPathConstants.STORAGEMEMBERS+"/{assetInfo}");
        CommonMethods.getJSONPathWithParam(assetInfoId);

    }
    @Step
    public static String getStorageMemberid(String storageMemberName, String brandNme, String categoryName,String assetSeries,String brandVersion,String storage,String ram) throws Exception {
        createStorageRequest(brandNme,categoryName,assetSeries,brandVersion,storage,ram);
        return CommonMethods.getBrandCharacteristic(storageMemberName,"data.stores[0].name","data.stores[0].storeId");

    }
    @Step
    public static String getCountryName(String storageMemberName,String brandNme, String categoryName,String assetSeries,String brandVersion,String storage,String ram) throws Exception {
        createStorageRequest(brandNme,categoryName,assetSeries,brandVersion,storage,ram);
        String countryCode = CommonMethods.getBrandCharacteristic(storageMemberName,"data.stores[0].name","data.stores[0].country");

        switch(countryCode){
            case("United Arab Emirates"):
                storageMemberCountry = "UAE";
                break;
            case("Kingdom of Saudi Arabia"):
                storageMemberCountry = "KSR";
                break;

            default:
                throw new Exception("Invalid country name returned as "+ countryCode);

        }
        return storageMemberCountry;
    }


}
