package co.uk.motors.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorPageDisplay extends BasePage

{
    public ErrorPageDisplay(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "err")
    private WebElement errorPageTitle;

    public void isErrorPageDisplayed()

    {
        String errorTitle = errorPageTitle.getText();
        Assert.assertTrue(errorTitle.contains("We need a postcode to find cars in your area"));
    }

}
