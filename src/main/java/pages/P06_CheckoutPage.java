package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P06_CheckoutPage {
    WebDriver driver;

    public P06_CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By checkoutBtn = By.xpath("//a[@class='btn btn-primary']");
    public P06_CheckoutPage clickOnCheckoutBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.checkoutBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.checkoutBtn).click();
        return this;
    }
}
