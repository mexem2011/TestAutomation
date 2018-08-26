package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

/**
 * PaymentPage Pageobject class
 * @author Aleem
 */
public class PaymentPage extends PageObject {

    //Page properties
    @FindBy(xpath ="//a[@title='Pay by bank wire']")
    private WebElementFacade btnPayByBank;

    //Pay by bank wire
    public void payByBank(){
        btnPayByBank.waitUntilClickable().click();
    }
}
