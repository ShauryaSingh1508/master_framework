package com.test.api.pages;

import com.test.api.helpers.CommonMethods;
import com.test.api.pojo.reverseauction.AssetSpecification;
import com.test.api.pojo.reverseauction.ReverseAuction;
import com.test.api.utils.APIPathConstants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

@Epic("Appraisal creation")
@Feature("User should be able to create Appraisal")
public class ReversAuctionAPI extends CommonMethods {
    static ReverseAuction requestBody;
    static String brandName;
    static AssetSpecification attributeModelorSubseries;
    static AssetSpecification attributeModelOrstorage;
    static AssetSpecification attributeRamOrStorage;
    static List<AssetSpecification> assetSpecification = new ArrayList<>();


    public ReversAuctionAPI(String basePath, String endPoint) {
        super(basePath, endPoint);
    }

    @Step
    public static void createReverseAuctionAPI(String storageMemberName,String condition, String brandNme,String categoryName,String date, String assetSeries, String brandVersion, String storage, String ram, String email,String csName,String phoneNum) throws Exception {
        brandName = brandNme;

        requestBody = new ReverseAuction().setFreeQuoteId(FreequoteAPI.getFreequoteId(condition,brandNme,categoryName,date,assetSeries,brandVersion,storage,ram,email))
                                          .setStorageProviderId(StorageMembers
                                                  .getStorageMemberid(storageMemberName,brandName,categoryName,assetSeries,brandVersion,storage,ram))
                                          .setCategoryType(ActivelistPage.shouldReturnCategoryType(categoryName)).setEmail(email)
                                          .setModel(assetSeries)
                                          .setAssetSpecifications(getlistAssetSpec(brandVersion,storage,ram))
                                          .setCountryCode(StorageMembers.getCountryName(storageMemberName,brandName,categoryName,assetSeries,brandVersion,storage,ram))
                                          .setNoOfDays(0).setCustomerName(csName).setPhoneNo(phoneNum);


    }

    @Step
    private static List<AssetSpecification> getlistAssetSpec(String modelorSubseries, String modelOrstorage, String ramOrStorage) throws Exception {

        switch (brandName) {
            case "OnePlus":
            case "Vivo":

                attributeModelorSubseries = new AssetSpecification().setKey("Model").setValue(modelorSubseries);
                attributeModelOrstorage = new AssetSpecification().setKey("Storage").setValue(modelOrstorage);
                attributeRamOrStorage = new AssetSpecification().setKey("RAM").setValue(ramOrStorage);

                assetSpecification.add(attributeModelorSubseries);
                assetSpecification.add(attributeModelOrstorage);
                assetSpecification.add(attributeRamOrStorage);
                break;
            case "Xiaomi":
                attributeModelorSubseries = new AssetSpecification().setKey("Model").setValue(modelorSubseries);
                attributeModelOrstorage = new AssetSpecification().setKey("Storage space").setValue(modelOrstorage);
                attributeRamOrStorage = new AssetSpecification().setKey("RAM").setValue(ramOrStorage);

                assetSpecification.add(attributeModelorSubseries);
                assetSpecification.add(attributeModelOrstorage);
                assetSpecification.add(attributeRamOrStorage);
                break;

            case "Samsung":
            case "Huawei":
            case "Oppo":

                attributeModelorSubseries = new AssetSpecification().setKey("Subseries").setValue(modelorSubseries);
                attributeModelOrstorage = new AssetSpecification().setKey("Model").setValue(modelOrstorage);
                attributeRamOrStorage = new AssetSpecification().setKey("Storage").setValue(ramOrStorage);

                assetSpecification.add(attributeModelorSubseries);
                assetSpecification.add(attributeModelOrstorage);
                assetSpecification.add(attributeRamOrStorage);
                break;
            case "google":
                attributeModelorSubseries = new AssetSpecification().setKey("Model").setValue(modelorSubseries);
                attributeModelOrstorage = new AssetSpecification().setKey("Storage Space").setValue(modelOrstorage);

                assetSpecification.add(attributeModelorSubseries);
                assetSpecification.add(attributeModelOrstorage);
                break;


            default:
                attributeModelOrstorage = new AssetSpecification().setKey("Storage").setValue(modelOrstorage);
                assetSpecification.add(attributeModelOrstorage);

        }

        return assetSpecification;
    }

    @Step
    private static void postReverseAppraisalAPI(String storageMemberName, String condition, String brandNme,String categoryName,String date, String assetSeries, String brandVersion, String storage, String ram, String email,String csName,String phoneNum) throws Exception {
        createReverseAuctionAPI(storageMemberName,condition,brandNme,categoryName,date,assetSeries,brandVersion,storage,ram,email,csName,phoneNum);
        new ReversAuctionAPI(APIPathConstants.BASE_PATH_CUSTOMER,
                APIPathConstants.BASE_PATH_APRAISAL +
                        APIPathConstants.REVERSEAUCTION);
        CommonMethods.postJSONPath(requestBody);

    }
    @Step
    public static String getAppraisalCode(String storageMemberName, String condition, String brandNme,String categoryName,String date, String assetSeries, String brandVersion, String storage, String ram, String email,String csName,String phoneNum) throws Exception {
        postReverseAppraisalAPI(storageMemberName,condition,brandNme,categoryName,date,assetSeries,brandVersion,storage,ram,email,csName,phoneNum);
        return String.valueOf(CommonMethods.getBrandCharacteristic("data.appraisalCode"));

    }



}
