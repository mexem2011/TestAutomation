package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends PageObject {

    @FindBy(name = "processAddress")
    private WebElementFacade btnCheckOut;

    public void proceedToShipping() {
        btnCheckOut.waitUntilClickable().click();
    }
}
