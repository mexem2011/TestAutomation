package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class CheckoutPopUp extends PageObject {

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElementFacade btnProceedToCheckout;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    WebElementFacade btnContinueShopping;


    public void continueShopping() {
        btnContinueShopping.waitUntilClickable().click();
    }

    public void checkout() {
        btnProceedToCheckout.waitUntilClickable().click();
    }
}
