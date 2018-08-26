package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class ConfirmOrderPage extends PageObject {

    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    private WebElementFacade btnConfirmOrder;

    public void confirmOrder() {
        btnConfirmOrder.waitUntilClickable().click();
    }
}
