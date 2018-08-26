package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import web.steps.WebSteps;

/**
 * Serenity Runner class to run the Web Tests
 * @author Aleem
 */
@RunWith(SerenityRunner.class)
public class WebTest {

    @Managed
    WebDriver driver;

    @Steps
    WebSteps webSteps;

    /**
     * Junit test to purchase two items
     */
    @Test
    public void endToEndTest(){
        //Load the URL
        webSteps.openURL();
        //Login to web applicatoin
        webSteps.logIn();
        //Quick view an item
        webSteps.quickViewItem();
        //Wait for quickview to load
        webSteps.waitForQuickViewPopUp();
        //Change the item size
        webSteps.changeSize();
        //Add item to cart
        webSteps.addToCart();
        //Continue shopping
        webSteps.continueShopping();
        //Quick view second item
        webSteps.quickViewItem();
        //Wait for quickview to load
        webSteps.waitForQuickViewPopUp();
        //Add item to cart
        webSteps.addToCart();
        //Proceed to basket page
        webSteps.checkout();
        //Verify items in basket
        webSteps.getBasetDetails();
        //Proceed to address page
        webSteps.proceedToAddress();
        //Proceed to shipping page
        webSteps.proceedToShipping();
        //Proceed to payment page
        webSteps.proceedToPayment();
        //Pay by bank wire
        webSteps.payByBank();
        //Confirm order
        webSteps.confirmOrder();
    }
}
