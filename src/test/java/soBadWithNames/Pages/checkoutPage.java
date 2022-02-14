package soBadWithNames.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import soBadWithNames.domainObjects.billingDetails;

public class checkoutPage extends BasePage{

    @FindBy(xpath = "//input[@id=\"billing_first_name\"]") private WebElement billingFirstNameFld;
    @FindBy(xpath = "//input[@id=\"billing_last_name\"]") private WebElement billingLastNameFld;
    @FindBy(xpath = "//input[@id=\"billing_address_1\"]") private WebElement billingAddressOneFld;
    @FindBy(xpath = "//input[@id=\"billing_city\"]") private WebElement billingCityFld;
    @FindBy(id = "billing_state") private WebElement billingStateDropdown;
    @FindBy(id = "select2-billing_state-container") private WebElement alternateBillingStateDropdown;
    @FindBy(xpath = "//input[@id=\"billing_postcode\"]") private WebElement billingZipFld;
    @FindBy(xpath = "//input[@id=\"billing_email\"]") private WebElement billingEmailFld;
    @FindBy(xpath = "//p[@class=\"woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received\"]") private WebElement orderConfirmationTxt;
    @FindBy(xpath = "//button[@id=\"place_order\"]") private WebElement placeOrderBtn;
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public checkoutPage(WebDriver driver) {
        super(driver);
    }

    public checkoutPage enterBillingFirstName(String billingFirstName){
        wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld)).clear();
        billingFirstNameFld.sendKeys(billingFirstName);
        return this;
    }

    public checkoutPage enterBillingLastName(String billingLastName){
        wait.until(ExpectedConditions.visibilityOf(billingLastNameFld)).clear();
        billingLastNameFld.sendKeys(billingLastName);
        return this;
    }

    public checkoutPage enterBillingAddressOne(String billingAddressOne){
        wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld)).clear();
        billingAddressOneFld.sendKeys(billingAddressOne);
        return this;
    }

    public checkoutPage enterBillingCity(String billingCity){
        wait.until(ExpectedConditions.visibilityOf(billingCityFld)).clear();
        billingCityFld.sendKeys(billingCity);
        return this;
    }

    public checkoutPage enterBillingZip(String billingZip){
        wait.until(ExpectedConditions.visibilityOf(billingZipFld)).clear();
        billingZipFld.sendKeys(billingZip);
        return this;
    }

    public checkoutPage enterBillingEmail(String billingEmail){
        wait.until(ExpectedConditions.visibilityOf(billingEmailFld)).clear();
        billingEmailFld.sendKeys(billingEmail);
        return this;
    }

    public checkoutPage selectBillingState(String billingStateName){
        wait.until(ExpectedConditions.elementToBeClickable(alternateBillingStateDropdown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" +  billingStateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        /*Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropdown)));
        select.selectByVisibleText(billingStateName);*/
        return this;
    }

    public checkoutPage setBillingDetails(billingDetails billing) {
        return enterBillingFirstName(billing.getBillingFirstName()).
                enterBillingLastName(billing.getBillingLastName()).
                enterBillingAddressOne(billing.getBillingAddressOne()).
                enterBillingCity(billing.getBillingCity()).
                selectBillingState(billing.getBillingStateName()).
                enterBillingZip(billing.getBillingZip()).
                enterBillingEmail(billing.getBillingEmail());
    }

    public checkoutPage placeOrder(){
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.visibilityOf(placeOrderBtn)).click();
        return this;
    }

    public String getConfirmation(){
        return wait.until(ExpectedConditions.visibilityOf(orderConfirmationTxt)).getText();
    }

}
