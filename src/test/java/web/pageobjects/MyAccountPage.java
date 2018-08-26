package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

/**
 * MyAccountPage Pageobject class
 * @author Aleem
 */
public class MyAccountPage extends PageObject {

    //Page properties
    @FindBy(xpath = "//a[@title='Home']")
    WebElementFacade btnHome;

    //Navigate to home page
    public void backToHome() {
        btnHome.waitUntilClickable().click();
    }
}
