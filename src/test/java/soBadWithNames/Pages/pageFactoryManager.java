package soBadWithNames.Pages;

import org.openqa.selenium.WebDriver;

public class pageFactoryManager {
    private static storePage storePage;
    private static cartPage cartPage;
    private static checkoutPage checkoutPage;

    public static storePage getStorePage(WebDriver driver){
        return storePage == null ? new storePage(driver) : storePage;
    }

    public static cartPage getCartPage(WebDriver driver){
        return cartPage == null ? new cartPage(driver) : cartPage;
    }

    public static checkoutPage getCheckoutPage(WebDriver driver){
        return checkoutPage == null ? new checkoutPage(driver) : checkoutPage;
    }
}
