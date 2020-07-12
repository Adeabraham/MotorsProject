package co.uk.motors.pages;

import co.uk.motors.commons.DriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BasePage extends DriverManager
{
    public String BASE_URL = "https://www.motors.co.uk/";
    public Select select;

    public void launchURL() {
        driver.navigate().to(BASE_URL);
    }

    public void selectByText(WebElement element, String text)
    {
        select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, int index)
    {
        select = new Select(element);
        select.selectByIndex(index);
    }
}

