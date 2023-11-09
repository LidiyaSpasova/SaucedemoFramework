package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage extends BasePage{
    protected WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    WebElement checkoutOverview;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @Override
    public boolean isAtCurrentPage() {
        return checkoutOverview.isDisplayed();
    }

    public CheckoutCompletePage finishCheckout(){
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}
