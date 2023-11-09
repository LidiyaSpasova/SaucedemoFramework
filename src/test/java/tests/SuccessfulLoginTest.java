package tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;

public class SuccessfulLoginTest extends TestUtil {

    @Test(dataProvider = "validUsersFromCsv")
    public void successfulLogin1(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage productPage = loginPage.login(userName,password);

        Assert.assertTrue(productPage.isAtCurrentPage());
    }
}
