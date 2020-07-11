package co.uk.motors.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage
{
    public HomePage(WebDriver driver)

    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="gdprAgree")
    private WebElement acceptCookieButton;
    @FindBy(name = "PostCode")
    private WebElement searchField;
    @FindBy(id = "Make")
    private WebElement carMake;
    @FindBy(id = "Model")
    private WebElement carModel;
    @FindBy(id = "MinPrice")
    private WebElement minPriceField;
    @FindBy(id = "MaxPrice")
    private WebElement maxPrice;
    @FindBy(className = "sp__btn-title")
    private WebElement enterField;

    public void clickOnCookieButton()
    {
        acceptCookieButton.click();
    }

    public void enterLocationCode(String Postcode)
    {
        searchField.sendKeys(Postcode);
    }

    public void selectCarMake(String selectMake)
    {
        selectByText(carMake, selectMake);
    }

    public void selectCarModel(String selectModel)
    {
        selectByText(carModel, selectModel);
    }

    public void selectMinPrice(String minimumPrice)
    {
        selectByText(minPriceField, minimumPrice);
    }

    public void selectMaxPrice(String maximumPrice)
    {
        selectByText(maxPrice, maximumPrice);
    }

    public SearchResultPage clickSearchButton ()
    {
        enterField.click();
        return new SearchResultPage(driver);
    }
}
