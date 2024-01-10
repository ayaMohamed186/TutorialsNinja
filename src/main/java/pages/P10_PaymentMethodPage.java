package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P10_PaymentMethodPage {

    WebDriver driver;

    public P10_PaymentMethodPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By continuePaymentMethod = By.xpath("//input[@id='button-payment-method']");
    private final By confirmTermsBtn = By.xpath("//input[@type='checkbox']");
    public P10_PaymentMethodPage clickOnConfirmTerms(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.confirmTermsBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.confirmTermsBtn).click();
        return this;
    }
    public P10_PaymentMethodPage clickOnContinuePaymentMethod(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continuePaymentMethod));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continuePaymentMethod).click();
        return this;
    }

}
