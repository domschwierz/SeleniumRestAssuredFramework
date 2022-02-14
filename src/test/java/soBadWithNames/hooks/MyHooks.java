package soBadWithNames.hooks;

import io.cucumber.java.Scenario;
import soBadWithNames.context.testContext;
import soBadWithNames.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private WebDriver driver;
    private final testContext context;

    public MyHooks(testContext context){
        this.context = context;
    }

    @Before
    public void before(Scenario scenario){
        System.out.println("BEFORE: THREAD ID: " + Thread.currentThread().getId() + ", " +
                "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        context.driver = driver;
    }

    @After
    public void after(Scenario scenario){
        System.out.println("AFTER: THREAD ID: " + Thread.currentThread().getId() + ", " +
                "SCENARIO NAME: " + scenario.getName());
        driver.quit();
    }
}
