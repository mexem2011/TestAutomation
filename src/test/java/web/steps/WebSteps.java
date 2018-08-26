package web.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import web.pageobjects.*;

public class WebSteps extends ScenarioSteps {

    HomePage homePage;
    QuickViewPopUp quickViewPopUp;
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    CheckoutPopUp checkoutPopUp;
    BasketPage basketPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    ConfirmOrderPage confirmOrderPage;

    @Step
    public void quickViewItem() {
        homePage.quickViewItem();
    }

    @Step
    public void signIn() {
        homePage.signIn();
    }

    @Step
    public void logIn() {
        homePage.signIn();
        signInPage.logIn();
        myAccountPage.backToHome();
    }

    @Step
    public void backToHome() {
        myAccountPage.backToHome();
    }

    @Step
    public void openURL() {
        homePage.open();
    }

    @Step
    public void waitForQuickViewPopUp() {
        quickViewPopUp.waitForPopUp();
    }

    @Step
    public double getPrice() {
        return quickViewPopUp.getPrice();
    }

    @Step
    public void changeSize() {
        quickViewPopUp.changeSize();
    }

    @Step
    public void addToCart() {
        quickViewPopUp.addToCart();
    }

    @Step
    public void continueShopping() {
        checkoutPopUp.continueShopping();
    }

    @Step
    public void checkout() {
        checkoutPopUp.checkout();
    }

    @Step
    public void getBasetDetails() {
        basketPage.verifyProducts();
    }

    @Step
    public void proceedToAddress() {
        basketPage.proceedToAddress();
    }

    @Step
    public void proceedToPayment() {
        shippingPage.proceedToPayment();
    }

    @Step
    public void payByBank() {
        paymentPage.payByBank();
    }

    @Step
    public void confirmOrder() {
        confirmOrderPage.confirmOrder();
    }

    @Step
    public void proceedToShipping() {
        addressPage.proceedToShipping();
    }
}
