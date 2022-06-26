package soBadWithNames.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import soBadWithNames.Pages.checkoutPage;
import soBadWithNames.Pages.pageFactoryManager;
import soBadWithNames.constants.EndPoint;
import soBadWithNames.context.testContext;

public class checkoutStepDefinition {
    private final checkoutPage checkoutPage;
    private final testContext context;

    public checkoutStepDefinition(testContext context){
        checkoutPage = pageFactoryManager.getCheckoutPage(context.driver);
        this.context = context;
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        checkoutPage.setBillingDetails(context.billing);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getConfirmation());
    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        checkoutPage.load(EndPoint.CHECKOUT.url);
    }


}
