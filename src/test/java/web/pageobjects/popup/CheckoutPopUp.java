package web.pageobjects.popup;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

/**
 * CheckoutPopUp Pageobject class
 * @author Aleem
 */
public class CheckoutPopUp extends PageObject {

    //Page properties
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElementFacade btnProceedToCheckout;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    WebElementFacade btnContinueShopping;


    //Continue shopping
    public void continueShopping() {
        btnContinueShopping.waitUntilClickable().click();
    }

    //Checkout
    public void checkout() {
        btnProceedToCheckout.waitUntilClickable().click();
    }
}
