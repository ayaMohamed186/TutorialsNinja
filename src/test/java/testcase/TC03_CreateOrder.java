package testcase;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.*;
import util.Utility;

import java.io.IOException;

import static testcase.TC01_RegisterNewUser.email;
import static testcase.TC01_RegisterNewUser.password;
import static util.Utility.captureScreenshot;

public class TC03_CreateOrder extends TestBase{
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String address =faker.address().fullAddress();
    String city = faker.address().city();
    String postCode = faker.address().zipCode();

    @Test
    public void createOrder() throws InterruptedException {
        new P01_HomePage(driver).clickMyAccount().clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(email).fillPassword(password).clickOnLoginBtn();
        Assert.assertTrue(new P01_HomePage(driver).clickMyAccount().validateLogoutDisplayed());

        new P01_HomePage(driver).chooseSecondCategory().clickOnShowAll();
        new P04_ProductsPage(driver).addToCartItem1();

        String firstProductPrice = new P05_productDetailsPage(driver).getProductPrice();
        System.out.println(firstProductPrice);
        new P05_productDetailsPage(driver).clickOnAddCartBtn();

        new P01_HomePage(driver).chooseSecondCategory().clickOnShowAll();
        new P04_ProductsPage(driver).addToCartItem2();
        String secondProductPrice = new P05_productDetailsPage(driver).getProductPrice();
        System.out.println(secondProductPrice);
        new P05_productDetailsPage(driver).clickOnAddCartBtn();

        new P04_ProductsPage(driver).clickOnCheckoutBtn();
        new P01_HomePage(driver).clickOnViewCartAtPopup();
        new P06_CheckoutPage(driver).clickOnCheckoutBtn();

        new P07_BillingDetailsPage(driver).fillFirstName(firstName).fillLastName(lastName).fillAddress(address).
                fillCity(city).fillPostCode(postCode).selectCountry(5).selectState("117").clickOnContinueBtn();
        new P08_DeliveryDetailsPage(driver).clickOnContinueDeliveryDetails();
        new P09_DeliveryMethodPage(driver).clickOnContinueDeliveryMethod();
        new P10_PaymentMethodPage(driver).clickOnConfirmTerms().clickOnContinuePaymentMethod();
        new P11_ConfirmOrderPage(driver).clickOnConfirmOrder();

        captureScreenshot(driver, "OrderSuccess");

        Assert.assertEquals("Your order has been successfully processed!", new P12_SuccessOrderPage(driver).getSuccessMsg());
        new P12_SuccessOrderPage(driver).clickOnContinue();


    }
}
