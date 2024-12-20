package com.test.api.pages;

import com.test.api.helpers.CommonMethods;
import com.test.api.pojo.freequote.AssetAttributes;
import com.test.api.pojo.freequote.Attribute;
import com.test.api.utils.APIPathConstants;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class ActiveAssetAttributes {
    CommonMethods commonMethods;
    String assetId;
    List<Attribute> attributeList = new ArrayList<>();
    String brandName;
    AssetAttributes requestBody;
    Attribute attributeModelorSubseries;
    Attribute attributeModelOrstorage;
    Attribute attributeRamOrStorage;

    ActiveAssetAttributes(String brandNme, String categoryName, String assetSeries) throws Exception {
        try {
            brandName = brandNme;
            assetId = new com.test.api.pages.AssetGroups(brandName, categoryName).shouldReturnAssetSeriesId(assetSeries);
            new CommonMethods(APIPathConstants.BASE_PATH_ADMIN,
                    APIPathConstants.ASSETS + APIPathConstants.ACTIVE_ASSET_ATTRIBUTES + "/{assetId}");


        } catch (Exception e) {
            throw new Exception("Not able to get the url with the Asset id " + assetId);
        }

    }

    @Step
    private String getAssetId(String modelorSubseries, String modelOrstorage, String ramOrStorage) throws Exception {

        String value;

        switch (brandName) {
            case "OnePlus":
            case "Vivo":

                attributeModelorSubseries = Attribute.builder().key("Model").value(modelorSubseries).build();
                attributeModelOrstorage = Attribute.builder().key("Storage").value(modelOrstorage).build();
                attributeRamOrStorage = Attribute.builder().key("RAM").value(ramOrStorage).build();

                attributeList.add(attributeModelorSubseries);
                attributeList.add(attributeModelOrstorage);
                attributeList.add(attributeRamOrStorage);

                requestBody = AssetAttributes.builder().attributes(attributeList).build();
                CommonMethods.postJSONPathWithParam(assetId, requestBody);
                value = String.valueOf(CommonMethods.getBrandCharacteristic("data.assetInfo._id"));
                break;
            case "Xiaomi":
                attributeModelorSubseries = Attribute.builder().key("Model").value(modelorSubseries).build();
                attributeModelOrstorage = Attribute.builder().key("Storage space").value(modelOrstorage).build();
                attributeRamOrStorage = Attribute.builder().key("Ram ").value(ramOrStorage).build();

                attributeList.add(attributeModelorSubseries);
                attributeList.add(attributeModelOrstorage);
                attributeList.add(attributeRamOrStorage);

                requestBody = AssetAttributes.builder().attributes(attributeList).build();
                CommonMethods.postJSONPathWithParam(assetId, requestBody);
                value = String.valueOf(CommonMethods.getBrandCharacteristic("data.assetInfo._id"));
                break;

            case "Samsung":
            case "Huawei":
            case "Oppo":

                attributeModelorSubseries = Attribute.builder().key("Subseries").value(modelorSubseries).build();
                attributeModelOrstorage = Attribute.builder().key("Model").value(modelOrstorage).build();
                attributeRamOrStorage = Attribute.builder().key("Storage").value(ramOrStorage).build();

                attributeList.add(attributeModelorSubseries);
                attributeList.add(attributeModelOrstorage);
                attributeList.add(attributeRamOrStorage);

                requestBody = AssetAttributes.builder().attributes(attributeList).build();
                CommonMethods.postJSONPathWithParam(assetId, requestBody);
                value = String.valueOf(CommonMethods.getBrandCharacteristic("data.assetInfo._id"));
                break;
            case "google":
                attributeModelorSubseries = Attribute.builder().key("Model").value(modelorSubseries).build();
                attributeModelOrstorage = Attribute.builder().key("Storage Space").value(modelOrstorage).build();

                attributeList.add(attributeModelorSubseries);
                attributeList.add(attributeModelOrstorage);

                requestBody = AssetAttributes.builder().attributes(attributeList).build();
                CommonMethods.postJSONPathWithParam(assetId, requestBody);
                value = String.valueOf(CommonMethods.getBrandCharacteristic("data.assetInfo._id"));
                break;


            default:
                attributeModelOrstorage = Attribute.builder().key("Storage").value(modelOrstorage).build();
                attributeList.add(attributeModelOrstorage);

                requestBody = AssetAttributes.builder().attributes(attributeList).build();
                CommonMethods.postJSONPathWithParam(assetId, requestBody);
                value = String.valueOf(CommonMethods.getBrandCharacteristic("data.assetInfo._id"));


        }

        return value;


    }


    public String getAssetConfigId(String modelorSubseries, String modelOrstorage, String ramOrStorage) throws Exception {
        return getAssetId(modelorSubseries, modelOrstorage, ramOrStorage);

    }

}