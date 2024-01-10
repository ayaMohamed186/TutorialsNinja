package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P02_RegisterPage {

    WebDriver driver;

    public P02_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameInputField = By.id("input-firstname");
    private final By lastNameInputField = By.id("input-lastname");
    private final By emailInputField = By.id("input-email");
    private final By telephoneInputField = By.id("input-telephone");
    private final By passwordInputField = By.id("input-password");
    private final By confirmPasswordInputField = By.id("input-confirm");
    private final By termsOption = By.xpath("(//input[@value='1'])[3]");
    private final By submitRegister = By.xpath("//input[@value='Continue']");

    public P02_RegisterPage fillFirstName(String firstName) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstNameInputField));
        driver.findElement(this.firstNameInputField).sendKeys(firstName);
        return this;
    }
    public P02_RegisterPage fillLastName(String lastName) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.lastNameInputField));
        driver.findElement(this.lastNameInputField).sendKeys(lastName);
        return this;
    }
    public P02_RegisterPage fillEmail(String email) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.emailInputField));
        driver.findElement(this.emailInputField).sendKeys(email);
        return this;
    }
    public P02_RegisterPage fillTelephone(String telephone) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.telephoneInputField));
        driver.findElement(this.telephoneInputField).sendKeys(telephone);
        return this;
    }
    public P02_RegisterPage fillPassword(String password) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.passwordInputField));
        driver.findElement(this.passwordInputField).sendKeys(password);
        return this;
    }
    public P02_RegisterPage fillConfirmPassword(String confirmPassword) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.confirmPasswordInputField));
        driver.findElement(this.confirmPasswordInputField).sendKeys(confirmPassword);
        return this;
    }
    public P02_RegisterPage selectTerms() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.termsOption));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.termsOption).click();
        return this;
    }
    public P02_RegisterPage clickOnSubmitRegister() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitRegister));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.submitRegister).click();
        return this;
    }


}
