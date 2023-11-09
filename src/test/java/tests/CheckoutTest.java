package tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;

public class CheckoutTest extends TestUtil {
    @Test
    public void checkOut() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage productPage = loginPage.login("standard_user", "secret_sauce");
        productPage.addItemToTheCart("fleece-jacket");

        Assert.assertEquals(productPage.getItemsInTheCart(), 1);

        WebElement shoppingCartContainer = driver.findElement(By.cssSelector("[class='shopping_cart_badge']"));
        shoppingCartContainer.click();
        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();
    }
}

