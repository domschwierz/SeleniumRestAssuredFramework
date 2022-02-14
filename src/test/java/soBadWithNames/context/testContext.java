package soBadWithNames.context;

import org.openqa.selenium.WebDriver;
import soBadWithNames.domainObjects.Cookies;
import soBadWithNames.domainObjects.billingDetails;

public class testContext {
    public WebDriver driver;
    public billingDetails billing;
    public Cookies cookies;

    public testContext(){
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
    }
}
