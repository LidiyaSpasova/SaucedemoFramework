package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;

public class AddProductTest extends TestUtil {

    @Test
    public void successfulAddingProducts(){
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage productPage = loginPage.login("standard_user", "secret_sauce");
        productPage.addItemToTheCart("fleece-jacket");
        productPage.addItemToTheCart("bolt-t-shirt");
        Assert.assertEquals(productPage.getItemsInTheCart(),2,"Items was added");
    }

}
