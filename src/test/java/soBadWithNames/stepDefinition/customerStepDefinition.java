package soBadWithNames.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import soBadWithNames.Pages.storePage;
import soBadWithNames.constants.EndPoint;
import soBadWithNames.context.testContext;
import soBadWithNames.domainObjects.billingDetails;

public class customerStepDefinition {
    private final WebDriver driver;
    private final testContext context;

    public customerStepDefinition(testContext context){
        this.context = context;
        driver = context.driver;
    }

    @Given("I am a guest customer")
    public void iAmAGuestCustomer() {
        new storePage(driver).load(EndPoint.STORE.url);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(billingDetails billing) {
        context.billing = billing;
    }

}
