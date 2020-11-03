package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends BasePage {

    public LandingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="user_count")
    public WebElement UserCount;

    @FindBy(xpath = "//th[@class='sorting'][5]")
    public WebElement SortBorrowBook;

    @FindBy(xpath = "//i[@class='fa fa-pencil-square-o']")
    public List<WebElement> clickBorrowBook;

    public void click_toSort(){
        SortBorrowBook.click();
    }
    public void borrowBookClick(){
        clickBorrowBook.get(1).click();
    }


}
