package com.n11.step_definitions;

import com.n11.pages.BasePage;
import com.n11.pages.SearchPage;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class N11FilterStepDef {
    WebDriver driver= Driver.get();
    BasePage basePage= new BasePage();
    SearchPage searchPage=new SearchPage();

    @Given("User opens the browser and goes to home page")
    public void user_opens_the_browser_and_goes_to_home_page() {
        //Goes to the given url
        driver.get(ConfigurationReader.get("url"));
        //Confirmation of the expected url equals current url
        Assert.assertEquals(ConfigurationReader.get("url"), driver.getCurrentUrl());
    }

    @When("User searches a product {string}")
    public void user_searches_a_product(String product) {
        //Search a product
        basePage.searchProduct(product);
        //Confirms that searched product
        Assert.assertTrue(searchPage.resultText.getText().contains("Telefon"));
    }
    @Then("User selects some filters")
    public void user_selects_some_filters() {
        //Selecting the desired filters
        searchPage.setFilter();
        //Confirmation of the desired filters
        Select sortByCommentNumber = new Select(searchPage.sortByComNum);
        Assert.assertTrue(sortByCommentNumber.getFirstSelectedOption().getText().contains("Yorum sayısı"));
        Assert.assertTrue(searchPage.freeShippingCheckBox.isSelected());
    }


}
