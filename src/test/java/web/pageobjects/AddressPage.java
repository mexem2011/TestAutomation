package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

/**
 * AddressPage Pageobject class
 * @author Aleem
 */
public class AddressPage extends PageObject {

    //Page properties
    @FindBy(name = "processAddress")
    private WebElementFacade btnCheckOut;

    //Proceed to shipping
    public void proceedToShipping() {
        btnCheckOut.waitUntilClickable().click();
    }
}
