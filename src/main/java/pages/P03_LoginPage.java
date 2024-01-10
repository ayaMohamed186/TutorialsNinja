package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P03_LoginPage {

    WebDriver driver;

    public P03_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailInputField = By.id("input-email");
    private final By passwordInputField = By.id("input-password");
    private final By loginBtn = By.xpath("//input[@type='submit']");


    public P03_LoginPage fillEmail(String email) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.emailInputField));
        driver.findElement(this.emailInputField).sendKeys(email);
        return this;
    }
    public P03_LoginPage fillPassword(String password) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.passwordInputField));
        driver.findElement(this.passwordInputField).sendKeys(password);
        return this;
    }
    public P03_LoginPage clickOnLoginBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.loginBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.loginBtn).click();
        return this;
    }
}
