package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage{
    protected WebDriver driver;

    @FindBy(css = "[class='complete-header']")
    private WebElement completeText;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public CheckoutCompletePage finishCheckout(){
        backHomeButton.click();
        return new CheckoutCompletePage(driver);
    }

    @Override
    public boolean isAtCurrentPage() {
        return completeText.isDisplayed();
    }
}
