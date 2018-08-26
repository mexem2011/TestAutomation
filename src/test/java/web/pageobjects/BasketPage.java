package web.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.util.Product;
import web.util.Utility;

import java.util.List;

/**
 * BasketPage Pageobject class
 * @author Aleem
 */
public class BasketPage extends PageObject {

    //Page properties
    @FindBy(className = "cart_item")
    private List<WebElementFacade> cartItems;

    @FindBy(id = "total_product")
    private WebElementFacade totalProductPrice;

    @FindBy(id = "total_shipping")
    private WebElementFacade shippingPrice;

    @FindBy(id = "total_price_without_tax")
    private WebElementFacade totalPrice;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
    private WebElementFacade btnCheckout;

    //Verify items in basket
    public void verifyProducts() {
        double totalPrice = 0;
        for (int count = 0; count < cartItems.size(); count++) {
            Product product = Utility.ITEMS_LIST.get(count);
            String size = cartItems.get(count).find(By.className("cart_description")).getText().split("Size : ")[1].trim();
            double price = Double.parseDouble(cartItems.get(count).find(By.className("cart_unit")).getText().trim().substring(1).split(" ")[0]);
            totalPrice = totalPrice + price;
            //Verify size is as expected
            Assert.assertEquals(product.getSize(), size);
            //Verify price is as expected
            Assert.assertEquals(String.valueOf(product.getPrice()), String.valueOf(price));
        }
        //Verify total price
        Assert.assertEquals(Math.round(totalPrice * 100D) / 100D, getTotalProductsPrice(), 0.00);
        //Verify total price with shipping
        Assert.assertEquals(Math.round((totalPrice + getShippingPrice()) * 100D) / 100D, getTotalPrice(), 0.00);

    }

    //Proceed to address page
    public void proceedToAddress() {
        btnCheckout.waitUntilClickable().click();
    }

    //Get total product price
    private double getTotalProductsPrice() {
        return Double.parseDouble(totalProductPrice.getText().trim().substring(1));
    }

    //Get shipping price
    private double getShippingPrice() {
        return Double.parseDouble(shippingPrice.getText().trim().substring(1));
    }

    //Get total price with shipping
    private double getTotalPrice() {
        return Double.parseDouble(totalPrice.getText().trim().substring(1));
    }
}
