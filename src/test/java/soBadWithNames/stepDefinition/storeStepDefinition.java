package soBadWithNames.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import soBadWithNames.APIs.cartApi;
import soBadWithNames.Pages.pageFactoryManager;
import soBadWithNames.Pages.storePage;
import soBadWithNames.constants.EndPoint;
import soBadWithNames.context.testContext;
import soBadWithNames.domainObjects.product;

public class storeStepDefinition {
    private final storePage storePage;
    private testContext context;

    public storeStepDefinition(testContext context){
        this.context = context;
        storePage = pageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the Store page")
    public void i_m_on_the_store_page() {
        storePage.load(EndPoint.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void iAddToTheCart(product product) {
        storePage.addToCart(product.getName());
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
//        storePage.addToCart("Blue Shoes");
        cartApi cartApi = new cartApi(context.cookies.getCookies());
        cartApi.addToCart(1215,1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
    }

}
