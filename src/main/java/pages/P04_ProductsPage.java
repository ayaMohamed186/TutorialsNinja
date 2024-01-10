package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P04_ProductsPage {
    WebDriver driver;

    public P04_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By addProductForFirstItem = By.xpath("(//button[@type='button'])[9]");
    private final By addProductForSecondItem = By.xpath("(//div[@class='caption']/h4/a)[2]");
    private final By checkoutBtn = By.id("cart-total");
    public P04_ProductsPage addToCartItem1() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addProductForFirstItem));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.addProductForFirstItem).click();
        return this;
    }


    public P04_ProductsPage addToCartItem2() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addProductForSecondItem));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.addProductForSecondItem).click();
        return this;
    }

    public P04_ProductsPage clickOnCheckoutBtn() {
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
