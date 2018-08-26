package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

/**
 * ConfirmOrderPage Pageobject class
 * @author Aleem
 */
public class ConfirmOrderPage extends PageObject {

    //Page properties
    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    private WebElementFacade btnConfirmOrder;

    //Confirm order
    public void confirmOrder() {
        btnConfirmOrder.waitUntilClickable().click();
    }
}
