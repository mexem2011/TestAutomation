package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import web.steps.WebSteps;

@RunWith(SerenityRunner.class)
public class WebTest {

    @Managed
    WebDriver driver;

    @Steps
    WebSteps webSteps;

    @Test
    public void testExample(){
        webSteps.openURL();
        webSteps.logIn();
        webSteps.quickViewItem();
        webSteps.waitForQuickViewPopUp();
        webSteps.changeSize();
        webSteps.addToCart();
        webSteps.continueShopping();
        webSteps.quickViewItem();
        webSteps.waitForQuickViewPopUp();
        webSteps.addToCart();
        webSteps.checkout();
        webSteps.getBasetDetails();
        webSteps.proceedToAddress();
        webSteps.proceedToShipping();
        webSteps.proceedToPayment();
        webSteps.payByBank();
        webSteps.confirmOrder();
    }
}
