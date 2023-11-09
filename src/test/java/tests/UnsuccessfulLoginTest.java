package tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class UnsuccessfulLoginTest extends TestUtil {
    @Test(dataProvider = "unValidUsers")
    public void unSuccessfulLogin1(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement invalidLoginErrorMessage = driver.findElement(By.xpath("//button[contains(@data-test,'')]"));
        wait.until(ExpectedConditions.visibilityOf(invalidLoginErrorMessage));

        Assert.assertTrue(loginPage.isAtCurrentPage());
    }
}

