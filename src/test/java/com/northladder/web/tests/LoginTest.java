package com.northladder.web.tests;


import com.northladder.api.actions.CartApi;
import com.northladder.api.actions.SignUpApi;
import com.northladder.commonutils.FakerUtils;
import com.northladder.web.base.BaseTest;
import com.northladder.web.objects.Product;
import com.northladder.web.objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginDuringCheckout() throws Exception {
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demopwd").
                setEmail(username + "@askomdch.com");

        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
        CartApi cartApi = new CartApi();
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

/*        CheckoutPageWeb checkoutPage = new CheckoutPageWeb(getDriver()).load();
        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();
        checkoutPage.
                clickHereToLoginLink().
                login(user);
        Assert.assertTrue(checkoutPage.getProductName().contains(product.getName()));*/
    }
}
