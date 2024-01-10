package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P08_DeliveryDetailsPage {
    WebDriver driver;

    public P08_DeliveryDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By continueDeliveryDetails = By.xpath("//input[@id='button-shipping-address']");
    public P08_DeliveryDetailsPage clickOnContinueDeliveryDetails(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueDeliveryDetails));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continueDeliveryDetails).click();
        return this;
    }

}
