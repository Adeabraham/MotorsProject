package co.uk.motors.stepDefinitions;

import co.uk.motors.pages.BasePage;
import co.uk.motors.pages.HomePage;
import co.uk.motors.pages.ProductDetailPage;
import co.uk.motors.pages.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchForAnyCarByPostcode extends BasePage

{

    //Instantiation:
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
    ProductDetailPage productDetailPage = PageFactory.initElements(driver, ProductDetailPage.class);

    @Given("I navigate to motors homepage")
    public void i_navigate_to_motors_homepage()
    {
       //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        homePage.launchURL();
        homePage.clickOnCookieButton();
    }

    @When("I enter {string} into the postcode field")
    public void i_enter_into_the_postcode_field(String Postcode)
    {
        homePage.enterLocationCode(Postcode);
    }

    @When("I select {string} from Make dropdown")
    public void i_select_any_car_of_my_choice_from_Make_Any_dropdown(String selectMake)
    {
      homePage.selectCarMake(selectMake);
    }

    @When("I select {string} from Model dropdown")
    public void i_select_any_model_of_my_choice_from_Model_Any_dropdown(String selectModel)
    {
      homePage.selectCarModel(selectModel);
    }

    @When("I select {string} from Min Price drop down")
    public void i_select_any_price_of_my_choice_from_Min_Price_drop_down(String minimumPrice)
    {
      homePage.selectMinPrice(minimumPrice);
    }

    @When("I select {string} from Max Price drop down")
    public void i_select_any_price_of_my_choice_from_Max_Price_drop_down(String maximumPrice)
    {
      homePage.selectMaxPrice(maximumPrice);
    }

    @When("I select {string} out of the HighestPrice drop down")
    public void i_select_out_of_the_HighestPrice_drop_down(String maximumPrice)
    {
        homePage.selectMaxPrice(maximumPrice);
    }

    @When("I click on search button")
    public void i_click_on_search_button()
    {
       searchResultPage=homePage.clickSearchButton();
    }

    @Then("the search for {string} is displayed")
    public void a_page_is_displayed_showing_the_cars_in_the_postcode(String Postcode)
    {
       //
    }

    @Then("I click on one of the search results")
    public void i_click_on_one_of_the_search_results()
    {
     productDetailPage = searchResultPage.clickOnAnyResult();
    }

}



//@When("I select {string} out of the HighestPrice drop down")
//public void i_select_out_of_the_HighestPrice_drop_down(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}