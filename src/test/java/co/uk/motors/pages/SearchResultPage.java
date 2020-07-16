package co.uk.motors.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
@FindBy(css = ".item.btn") //check if there is a need for a dot afterbtn
private List<WebElement> details;

    public ProductDetailPage clickOnTheFirstResult()
    {
        //cancelPopUp.click();  i.e. in case of any pop up
        details.get(0).click();
        return new ProductDetailPage(driver);
    }

    public ProductDetailPage clickOnAnyResult()
    {
        int noOfElement = details.size();
        Random random = new Random();
        int ranNumber =random.nextInt( noOfElement - 1);
        //cancelPopUp.click();   i.e. in case of any pop up
        details.get(ranNumber).click();

        return  new ProductDetailPage(driver);
    }

}