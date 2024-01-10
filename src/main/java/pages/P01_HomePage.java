package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P01_HomePage {
    WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By myAccountBtn = By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[3]");
    private final By registerBtn = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[1]/a");
    private final By loginBtn = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a");
    private final By logoutBtn = By.xpath("//li[@class='dropdown open']/ul/li[5]");
    private final By secondCategory = By.xpath("(//a[@class='dropdown-toggle'])[3]");
    private final By showAllForSecondCategory = By.xpath("(//a[@class='see-all'])[2]");
    private final By viewCartBtn = By.xpath("//p[@class=\"text-right\"]/a");

    public P01_HomePage clickOnViewCartAtPopup(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.viewCartBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.viewCartBtn).click();
        return this;
    }
    public P01_HomePage clickMyAccount(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.myAccountBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.myAccountBtn).click();
        return this;
    }
    public P01_HomePage clickRegisterBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.registerBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.registerBtn).click();
        return this;
    }
    public P01_HomePage clickLoginBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.loginBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.loginBtn).click();
        return this;
    }

    public P01_HomePage clickLogout(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.logoutBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.logoutBtn).click();
        return this;
    }

    public boolean validateLogoutDisplayed(){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.logoutBtn));
        return driver.findElement(this.logoutBtn).isDisplayed();
    }

    public P01_HomePage chooseSecondCategory(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.secondCategory));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.secondCategory).click();
        return this;
    }

    public P01_HomePage clickOnShowAll(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.showAllForSecondCategory));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.showAllForSecondCategory).click();
        return this;
    }
}
