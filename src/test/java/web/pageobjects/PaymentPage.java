package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageObject {

    @FindBy(xpath ="//a[@title='Pay by bank wire']")
    private WebElementFacade btnPayByBank;

    public void payByBank(){
        btnPayByBank.waitUntilClickable().click();
    }
}
