package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P07_BillingDetailsPage {
    WebDriver driver;

    public P07_BillingDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameInputField = By.xpath("//input[@name='firstname']");
    private final By lastNameInputField = By.xpath("//input[@name='lastname']");
    private final By addressInputField = By.xpath("//input[@name='address_1']");
    private final By cityInputField = By.xpath("//input[@name='city']");
    private final By postCodeInputField = By.xpath("//input[@name='postcode']");
    private final By country = By.xpath("//select[@name='country_id']");
    private final By state = By.xpath("//select[@id='input-payment-zone']");
    //id="input-payment-zone"
    private final By continueBtn = By.id("button-payment-address");

    public P07_BillingDetailsPage fillFirstName(String firstName) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.firstNameInputField));
        driver.findElement(this.firstNameInputField).sendKeys(firstName);
        return this;
    }
    public P07_BillingDetailsPage fillLastName(String lastName) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.lastNameInputField));
        driver.findElement(this.lastNameInputField).sendKeys(lastName);
        return this;
    }
    public P07_BillingDetailsPage fillAddress(String address) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addressInputField));
        driver.findElement(this.addressInputField).sendKeys(address);
        return this;
    }
    public P07_BillingDetailsPage fillCity(String city) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.cityInputField));
        driver.findElement(this.cityInputField).sendKeys(city);
        return this;
    }
    public P07_BillingDetailsPage fillPostCode(String postCode) {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.postCodeInputField));
        driver.findElement(this.postCodeInputField).sendKeys(postCode);
        return this;
    }
    public P07_BillingDetailsPage selectCountry(int index){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.country));
        WebElement countryElement = driver.findElement(this.country);
        Select countryS = new Select(countryElement);
        countryS.selectByIndex(index);
        return this;
    }
    public P07_BillingDetailsPage selectState(String index){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.state));
        WebElement stateElement = driver.findElement(this.state);
        Select stateS = new Select(stateElement);
        stateS.selectByValue(index);
        return this;
    }
    public P07_BillingDetailsPage clickOnContinueBtn(){
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
