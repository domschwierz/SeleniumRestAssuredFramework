package soBadWithNames.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class cartPage extends BasePage{
    @FindBy(xpath = "//td[@class=\"product-name\"]") private WebElement productNameTxt;
    @FindBy(xpath = "//input[@class=\"input-text qty text\"]") private WebElement productQuantityTxt;
    @FindBy(xpath = " //a[@class=\"checkout-button button alt wc-forward\"]") private WebElement checkoutButton;

    public cartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOf(productNameTxt)).getText();
    }

    public int getProductQuantity(){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQuantityTxt))
                .getAttribute("value"));
    }

    public void checkout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

}
