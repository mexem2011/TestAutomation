package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

/**
 * ShippingPage Pageobject class
 * @author Aleem
 */
public class ShippingPage extends PageObject {

    //Page properties
    @FindBy(id = "uniform-cgv")
    private WebElementFacade chkAgree;

    @FindBy(name = "processCarrier")
    private WebElementFacade btnCheckout;

    //Proceed to payment
    public void proceedToPayment() {
        chkAgree.waitUntilClickable().click();
        btnCheckout.waitUntilClickable().click();
    }
}