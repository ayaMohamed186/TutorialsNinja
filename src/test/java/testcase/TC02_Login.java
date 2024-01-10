package testcase;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import util.Utility;

import java.io.IOException;

import static util.Utility.captureScreenshot;


public class TC02_Login extends TestBase {
    String email1 = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/ValidloginData.json", "email");
    String password1 = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/ValidloginData.json", "password");

    public TC02_Login() throws IOException, ParseException {
    }

    // these annotations for allure
    @Description("login with valid data ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login")
    @Test
    public void loginWithRegisterUser_P(){
        new P01_HomePage(driver).clickMyAccount().clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(email1).fillPassword(password1).clickOnLoginBtn();

        captureScreenshot(driver, "loggedWithRegisterUserManual");
        Assert.assertTrue(new P01_HomePage(driver).clickMyAccount().validateLogoutDisplayed());

    }
}
