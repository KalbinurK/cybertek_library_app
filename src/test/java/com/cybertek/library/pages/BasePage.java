package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage { // we can not create abj from this abstract class
   public BasePage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(linkText = "Users")
    public WebElement UserPageLink;

   @FindBy(linkText = "Books")
    public WebElement bookPageLink;

   @FindBy(linkText = "Dashboard")
    public WebElement dashboardPageLink;

}
