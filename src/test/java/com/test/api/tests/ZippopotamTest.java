package com.test.api.tests;

import com.test.api.pages.Zippopotam;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ZippopotamTest{

  @Parameters({ "countryCode", "postalCode","countryName"})
  @Test(description = "Should be able to return the name of the country")
  public static void getCountryName(@Optional String countryCode, @Optional String postalCode,@Optional String countryName) throws Exception {
      String actualCountryName = new Zippopotam(countryCode,postalCode).shouldReturnCountryName();
      Assert.assertEquals(countryName,actualCountryName);

  }

    @Parameters({ "countryCode", "postalCode"})
    @Test(description = "Should be able to return the state of the country")
    public static void getStateName(@Optional String countryCode, @Optional String postalCode) throws Exception {
        String actualStateName = new Zippopotam(countryCode,postalCode).shouldReturnStateName();
        String statusCode = new Zippopotam(countryCode,postalCode).shouldReturnStateName();
        Assert.assertEquals("Delhi",actualStateName);

    }


}
