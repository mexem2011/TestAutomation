package web.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * SignInPage Pageobject class
 * @author Aleem
 */
public class SignInPage extends PageObject {

    //Page properties
    @FindBy(id = "email")
    WebElementFacade txtEmail;

    @FindBy(id = "passwd")
    WebElementFacade txtPassword;

    @FindBy(id = "SubmitLogin")
    WebElementFacade btnSignIn;

    //Login with valid credentials
    public void logIn() {
        txtEmail.waitUntilVisible().sendKeys("automationpractice123@gmail.com");
        txtPassword.waitUntilVisible().sendKeys("BJSSTest");
        btnSignIn.waitUntilClickable().click();
    }
}
