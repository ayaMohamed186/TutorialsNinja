package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P09_DeliveryMethodPage {

    WebDriver driver;

    public P09_DeliveryMethodPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By continueDeliveryMethod = By.xpath("//input[@id='button-shipping-method']");
    public P09_DeliveryMethodPage clickOnContinueDeliveryMethod(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueDeliveryMethod));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continueDeliveryMethod).click();
        return this;
    }

}
