package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage{

    private final static String ID_PRODUCT_BASE = "add-to-cart-sauce-labs-";
    private final static String ID_REMOVE_PRODUCT_BASE = "remove-sauce-labs-";
    @FindBy(xpath = "//span[@class='title']")
    WebElement pageTitle;

    @FindBy(id = "react-burger-menu-btn")
    WebElement userMenu;

    @FindBy(css = "[class='shopping_cart_badge']")
    WebElement shoppingCartBadge;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void addItemToTheCart(String itemName){
        //dynamically build the element locator:
        WebElement itemTobeAdded = driver.findElement(By.id(ID_PRODUCT_BASE + itemName));
        itemTobeAdded.click();
    }


    public int getItemsInTheCart(){
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    @Override
    public boolean isAtCurrentPage() {
        return pageTitle.isDisplayed();
    }

    public CartPage openCart() {
        shoppingCartBadge.click();
        return new CartPage(driver);
    }
}
