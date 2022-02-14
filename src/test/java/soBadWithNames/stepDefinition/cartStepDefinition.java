package soBadWithNames.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import soBadWithNames.Pages.cartPage;
import soBadWithNames.Pages.pageFactoryManager;
import soBadWithNames.context.testContext;
import soBadWithNames.domainObjects.product;

public class cartStepDefinition {
    private final cartPage cartPage;

    public cartStepDefinition(testContext context){
        cartPage = pageFactoryManager.getCartPage(context.driver);
    }

    @Then("I see {int} {product} in the cart")
    public void i_see_in_the_cart(int quantity, product product) {
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(cartPage.getProductQuantity(), quantity);
    }
}
