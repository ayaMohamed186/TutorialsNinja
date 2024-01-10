package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegisterPage;

import static util.Utility.captureScreenshot;

public class TC01_RegisterNewUser extends TestBase {

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    static String email = faker.internet().emailAddress();
    String telephone = faker.phoneNumber().phoneNumber();
    static String password = faker.internet().password();
    String confirmPassword = password;

    @Test
    public void registerNewUser() {
        new P01_HomePage(driver).clickMyAccount().clickRegisterBtn();
        new P02_RegisterPage(driver).fillFirstName(firstName).fillLastName(lastName).fillEmail(email).
                fillTelephone(telephone).fillPassword(password).fillConfirmPassword(confirmPassword).
                selectTerms().clickOnSubmitRegister();

        captureScreenshot(driver, "RegisterNewUser");
        Assert.assertTrue(new P01_HomePage(driver).clickMyAccount().validateLogoutDisplayed());
    }
}
