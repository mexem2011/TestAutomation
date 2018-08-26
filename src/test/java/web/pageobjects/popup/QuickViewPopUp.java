package web.pageobjects.popup;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import web.util.Product;
import web.util.Utility;

/**
 * QuickViewPopUp Pageobject class
 * @author Aleem
 */
public class QuickViewPopUp extends PageObject {

    //Page properties
    @FindBy(id = "our_price_display")
    WebElementFacade txtPrice;

    @FindBy(id = "group_1")
    WebElement selectSize;

    @FindBy(id = "add_to_cart")
    WebElementFacade btnAddToCart;

    @FindBy(className = "fancybox-iframe")
    WebElementFacade popUpiFrame;

    //Wait for pop
    public void waitForPopUp() {
        popUpiFrame.waitUntilVisible();
        switchToiFrame();
    }

    //Get price of an item
    public double getPrice() {
        return Double.parseDouble(txtPrice.getText().substring(1));
    }

    //Change the size of an item
    public void changeSize() {
        Select select = new Select(selectSize);
        select.selectByVisibleText("L");
    }

    //Get the size of an item
    private String getSize() {
        Select select = new Select(selectSize);
        return select.getFirstSelectedOption().getText();
    }

    //Add an item to cart
    public void addToCart() {
        //Save size and price of an item
        Product product = new Product();
        product.setPrice(getPrice());
        product.setSize(getSize());
        product.setCount(Utility.ITEMS_LIST.size());
        Utility.ITEMS_LIST.add(product);
        //add to cart
        btnAddToCart.waitUntilClickable().click();
    }

    //Switch to frame
    private void switchToiFrame() {
        getDriver().switchTo().frame(popUpiFrame);
    }
}
