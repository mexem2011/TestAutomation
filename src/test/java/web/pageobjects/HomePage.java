package web.pageobjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import web.util.Product;
import web.util.Utility;

import java.util.List;
import java.util.Random;

@DefaultUrl("http://automationpractice.com/")
public class HomePage extends PageObject {

    @FindBy(xpath = "//*[@id='homefeatured']/li")
    private List<WebElementFacade> featuredItems;

    @FindBy(className = "login")
    WebElementFacade btnSignin;

    public void signIn() {
        btnSignin.waitUntilVisible().click();
    }

    public void quickViewItem() {
        //Get featured items count
        int itemsCount = featuredItems.size();
        //To pick random item
        int randomItem = getRandom(itemsCount);

        if (Utility.RANDOM_INT == 0) {
            Utility.RANDOM_INT = randomItem;
        } else {
            while (Utility.RANDOM_INT == randomItem) {
                randomItem = getRandom(itemsCount);
            }
        }
        //Mouse-hover/Move to the item
        WebElementFacade itemQuickView = featuredItems.get(randomItem);
        withAction().moveToElement(itemQuickView).build().perform();
        //Click on Quick View button
        itemQuickView.find(By.className("quick-view")).waitUntilVisible().click();
    }

    private int getRandom(int itemsCount) {
        return new Random().nextInt(itemsCount);
    }
}
