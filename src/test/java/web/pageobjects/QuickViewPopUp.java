package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import web.util.Product;
import web.util.Utility;

public class QuickViewPopUp extends PageObject {

    @FindBy(id = "our_price_display")
    WebElementFacade txtPrice;

    @FindBy(id = "group_1")
    WebElement selectSize;

    @FindBy(id = "add_to_cart")
    WebElementFacade btnAddToCart;

    @FindBy(className = "fancybox-iframe")
    WebElementFacade popUpiFrame;

    public void waitForPopUp() {
        popUpiFrame.waitUntilVisible();
        switchToiFrame();
    }

    public double getPrice() {
        return Double.parseDouble(txtPrice.getText().substring(1));
    }

    public void changeSize() {
        Select select = new Select(selectSize);
        select.selectByVisibleText("L");
    }

    private String getSize() {
        Select select = new Select(selectSize);
        return select.getFirstSelectedOption().getText();
    }

    public void addToCart() {
        Product product = new Product();
        product.setPrice(getPrice());
        product.setSize(getSize());
        product.setCount(Utility.ITEMS_LIST.size());
        Utility.ITEMS_LIST.add(product);
        btnAddToCart.waitUntilClickable().click();
    }

    private void switchToiFrame() {
        getDriver().switchTo().frame(popUpiFrame);
    }
}
