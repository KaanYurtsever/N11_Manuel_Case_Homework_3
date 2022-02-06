package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SearchPage extends BasePage {

    //Result text of searched product
    @FindBy(className = "resultText")
    public WebElement resultText;

    //Second brand box
    @FindBy(xpath = "//*[@class=\"filter\"][2]/div[2]/div[2]/label/input")
    public WebElement secBrandCheckBox;
    //(//*[@class ="brand-checkbox"])[4]

    //Filter that sort by comment count
    @FindBy(id = "sortingType")
    public WebElement sortByComNum;

    //Free shipping box
    @FindBy(id = "freeShippingOption")
    public WebElement freeShippingCheckBox;

    public void setFilter(){
        WebDriverWait wait= new WebDriverWait(Driver.get(),Duration.ofSeconds(3));
        //Clicks on second brand
        secBrandCheckBox.click();
        //Waits until that wanted elements are clickable
        wait.until(ExpectedConditions.elementToBeClickable(freeShippingCheckBox));
        wait.until(ExpectedConditions.visibilityOf(sortByComNum));
        //Clicks on Comment Count filter
        Select sortByCommentNumber = new Select(sortByComNum);
        sortByCommentNumber.selectByVisibleText("Yorum sayısı");
        //Clicks on free shipping check box
        freeShippingCheckBox.click();
    }
}
