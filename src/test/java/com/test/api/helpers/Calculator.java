package com.test.api.helpers;

import com.test.api.pages.FreequoteAPI;
import com.test.api.utils.ConfigReader;
import io.qameta.allure.Step;


public class Calculator {

    static int flawlessSpotPrice;
    static int Spot_Price;
    static Number bbb_Service_Fee;
    static Number vat_BBB_Fee;
    static int assesmentmember_Fee;
    static int vat_Assessment_Fee;
    static Number actual_Price_Before_Rounding;
    static int actual_Price_After_Rounding;

    @Step
    public static boolean validateflawlessPrice(String condition, String brandName, String categoryName, String date, String assetSeries, String brandVersion, String storage, String ram, String email) throws Exception {
        boolean flag = false;
        try {
            flawlessSpotPrice = FreequoteAPI.getDealPrice(condition, brandName, categoryName, date, assetSeries, brandVersion, storage, ram, email);

            if (flawlessSpotPrice != 0)
                flag = true;

        } catch (Exception e) {

            throw new Exception("Unable to get the flawless spot price " + e);
        }
        return flag;

    }

    @Step
    public static boolean validateSpotPrice(String condition) throws Exception {
        boolean flag = false;
        try {
            Spot_Price = FreequoteAPI.getDealPrice();
            if(condition.equalsIgnoreCase("Below Average")) {
                condition="Below_Average";

            }else if(condition.equalsIgnoreCase("Broken but Working")){
                condition="Broken_but_Working";
            }
            int spotPrice = (flawlessSpotPrice * Integer.parseInt(ConfigReader.getInstance().getPropertyValue(condition))) / 100;
            if (Spot_Price == spotPrice)
                flag = true;

        } catch (Exception e) {
            throw new Exception("Unable to get the spot price " + e);
        }
        return flag;

    }

    @Step
    public static boolean validateNLadderServiceFee() throws Exception {
        boolean flag = false;
        try {
            bbb_Service_Fee = FreequoteAPI.getBbbServiceFee();
            int nLadderFeeCalculated = (Spot_Price * Integer.parseInt(ConfigReader.getInstance().getPropertyValue("BBB_Service_Fee_Spot"))) / 100;
            if (nLadderFeeCalculated < Integer.parseInt(ConfigReader.getInstance().getPropertyValue("BBB_Service_Fee_Spot_min")))
                nLadderFeeCalculated = Integer.parseInt(ConfigReader.getInstance().getPropertyValue("BBB_Service_Fee_Spot_min"));
            if (bbb_Service_Fee.intValue() == nLadderFeeCalculated)
                flag = true;

        } catch (Exception e) {
            throw new Exception("Unable to get the Service fee " + e);
        }
        return flag;

    }

    @Step
    public static boolean validateNLadderServiceFeeTax() throws Exception {
        boolean flag = false;
        try {
            vat_BBB_Fee = FreequoteAPI.getBbbServiceFeeTax();
            int nLaddertaxCalculated = (bbb_Service_Fee.intValue() * Integer.parseInt(ConfigReader.getInstance().getPropertyValue("VAT_BBB_Fee"))) / 100;
            if (vat_BBB_Fee.intValue() == nLaddertaxCalculated)
                flag = true;

        } catch (Exception e) {
            throw new Exception("Unable to get the Service fee " + e);
        }
        return flag;

    }

    @Step
    public static boolean validateNLadderAssesmentFee() throws Exception {
        boolean flag = false;
        try {
            assesmentmember_Fee = FreequoteAPI.getSellAsseseeFee();
            int AssesseFeeCalculated = (Spot_Price * Integer.parseInt(ConfigReader.getInstance().getPropertyValue("Storage_Fee_Spot"))) / 100;
            if (AssesseFeeCalculated < Integer.parseInt(ConfigReader.getInstance().getPropertyValue("Storage_Fee_Spot_min")))
                AssesseFeeCalculated = Integer.parseInt(ConfigReader.getInstance().getPropertyValue("Storage_Fee_Spot_min"));
            if (assesmentmember_Fee == AssesseFeeCalculated)
                flag = true;

        } catch (Exception e) {
            throw new Exception("Unable to get the Service fee " + e);
        }
        return flag;

    }

    @Step
    public static boolean validateNLadderAssesmentFeeTax() throws Exception {
        boolean flag = false;
        try {
            vat_Assessment_Fee = FreequoteAPI.getSellstorageFeeTax();
            int assesseFeeTaxCalculated = (assesmentmember_Fee * Integer.parseInt(ConfigReader.getInstance().getPropertyValue("VAT_Assesment_Fee"))) / 100;
            if (vat_Assessment_Fee == assesseFeeTaxCalculated)
                flag = true;

        } catch (Exception e) {
            throw new Exception("Unable to get the Service fee tax " + e);
        }
        return flag;

    }

    @Step
    public static boolean validateActualPriceBeforeRoundingOff() throws Exception {
        boolean flag = false;
        try {
            actual_Price_Before_Rounding = FreequoteAPI.getActualAmountBeforeRounding();
            Number actualAmount = Spot_Price - (bbb_Service_Fee.floatValue() + vat_BBB_Fee.floatValue() + assesmentmember_Fee + vat_Assessment_Fee);
            if (actual_Price_Before_Rounding.intValue() == actualAmount.intValue())
                flag = true;

        } catch (Exception e) {
            throw new Exception("Unable to get the Service fee tax " + e);
        }
        return flag;

    }

    @Step
    public static boolean validateActualSellingPrice() throws Exception {
        boolean flag = false;
        try {
            actual_Price_After_Rounding = FreequoteAPI.getActualAmountAfterAfterRounding();
            Number actualAmount = Spot_Price - (bbb_Service_Fee.intValue() + vat_BBB_Fee.intValue() + assesmentmember_Fee + vat_Assessment_Fee);
            int sellAmount = actualAmount.intValue() / 5;
            sellAmount = sellAmount * 5;
            if (actual_Price_After_Rounding == sellAmount)
                flag = true;

        } catch (Exception e) {
            throw new Exception("Unable to get the Service fee tax " + e);
        }
        return flag;

    }

}
