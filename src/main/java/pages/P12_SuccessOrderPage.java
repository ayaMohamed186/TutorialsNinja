package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P12_SuccessOrderPage {

    WebDriver driver;

    public P12_SuccessOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By successMsgForCompleteOrder = By.xpath("//div[@id='content']/p");
    private final By continueBtn = By.xpath("//a[@class='btn btn-primary']");

    public String getSuccessMsg() {
        longWait(driver).until(ExpectedConditions.elementToBeClickable(this.successMsgForCompleteOrder));
        return driver.findElement(this.successMsgForCompleteOrder).getText();
    }

    public P12_SuccessOrderPage clickOnContinue() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continueBtn).click();
        return this;
    }
}
