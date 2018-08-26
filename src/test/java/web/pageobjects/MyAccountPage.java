package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject {

    @FindBy(xpath = "//a[@title='Home']")
    WebElementFacade btnHome;

    public void backToHome() {
        btnHome.waitUntilClickable().click();
    }
}
