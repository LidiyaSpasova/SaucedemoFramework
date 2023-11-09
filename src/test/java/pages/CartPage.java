package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    private final static String ID_REMOVE_PRODUCT_BASE = "remove-sauce-labs-";

    @FindBy(xpath = "//span[@class='title']")
    WebElement yourCart;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    WebElement continueShopping;

    @FindBy(css = "[class='removed_cart_item']")
    WebElement removeButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void removeItemFromTheCart(String itemName){

        WebElement itemTobeRemoved = driver.findElement(By.id(ID_REMOVE_PRODUCT_BASE + itemName));
        itemTobeRemoved.click();
    }

    public int getItemsInTheCart(){
        return Integer.parseInt(removeButton.getText());
    }

    @Override
    public boolean isAtCurrentPage() {
        return yourCart.isDisplayed();
    }

    public CheckoutStepOnePage continueToCheckoutStepOnePage(){
        checkoutButton.click();
        return new CheckoutStepOnePage(driver);
    }
}




