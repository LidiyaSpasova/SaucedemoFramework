package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends CartPage{
    protected WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    WebElement checkoutYourInformation;


    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueSubmit;

    @FindBy(id = "cancel")
    private WebElement cancelSubmit;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public CheckoutStepTwoPage nameAndPostalCodeInput(){
        firstNameInput.clear();
        firstNameInput.sendKeys("Lidiya");

        lastNameInput.clear();
        lastNameInput.sendKeys("Spasova");

        postalCodeInput.clear();
        postalCodeInput.sendKeys("2700");

        continueSubmit.click();

        return new CheckoutStepTwoPage(driver);
    }

    @Override
    public boolean isAtCurrentPage() {
        return checkoutYourInformation.isDisplayed();
    }
}
