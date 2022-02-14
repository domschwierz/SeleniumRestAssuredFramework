package soBadWithNames.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class storePage extends BasePage{
    @FindBy(xpath = "//a[@class=\"added_to_cart wc-forward\"]") private WebElement viewCartLink;
    @FindBy(xpath = "//h1[normalize-space()='Store']") private WebElement titleText;


    public storePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName){
        By addToCartButton = By.xpath("//a[@aria-label=\"Add “" + productName + "” to your cart\"]");
        wait.until(ExpectedConditions.visibilityOf(titleText));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
