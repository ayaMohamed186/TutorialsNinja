package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P05_productDetailsPage {
    WebDriver driver;
    public P05_productDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By confirmAddToCart = By.xpath("//button[@id='button-cart']");
    private final By productPrice = By.xpath("//ul[@class='list-unstyled']/li/h2");

    public P05_productDetailsPage clickOnAddCartBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.confirmAddToCart));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.confirmAddToCart).click();
        return this;
    }

    public String getProductPrice(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productPrice));
        return driver.findElement(this.productPrice).getText();
    }
}
