package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends PageObject {

    @FindBy(id = "uniform-cgv")
    private WebElementFacade chkAgree;

    @FindBy(name = "processCarrier")
    private WebElementFacade btnCheckout;

    public void proceedToPayment() {
        chkAgree.waitUntilClickable().click();
        btnCheckout.waitUntilClickable().click();
    }
}