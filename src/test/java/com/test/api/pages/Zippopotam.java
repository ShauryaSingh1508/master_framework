package com.test.api.pages;

import com.test.api.helpers.CommonMethods;
import com.test.api.pojo.zippopotam.ZippopotamRootPojo;
import com.test.api.utils.APIPathConstants;

public class Zippopotam {

    String countryCodea;
    String postalCodea;

    public Zippopotam(String countryCode, String postalCode) throws Exception {
        try {


            new CommonMethods(APIPathConstants.BASE_PATH_ZIPPOPOTUM, countryCode + "/" + postalCode);
            CommonMethods.getZippopotamResponse();

        } catch (Exception e) {
            throw new Exception("Not able to get the url with " + countryCode + " and " + postalCode, e.getCause());
        }

    }

    public String shouldReturnCountryName() throws Exception {

        return CommonMethods.getZippopotamResponse().getCountry();

    }

    public String shouldReturnStateName() throws Exception {

        return CommonMethods.getZippopotamResponse().getPlaces().get(0).getState();

    }

}
