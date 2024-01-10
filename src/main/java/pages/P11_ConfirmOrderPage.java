package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P11_ConfirmOrderPage {

    WebDriver driver;

    public P11_ConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By confirmOrderBtn = By.xpath("//input[@id='button-confirm']");
    public P11_ConfirmOrderPage clickOnConfirmOrder(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.confirmOrderBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.confirmOrderBtn).click();
        return this;
    }
}
