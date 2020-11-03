package com.cybertek.library.pages;

import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){    //create constructor and intialized init ele by driver and object of this class
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "inputEmail")
    public WebElement EmailAddressInput;

    @FindBy(id = "inputPassword")
    public WebElement PasswordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement SignInButton;

    public void LibrarianLogin(){

        String LibraUsername= ConfigurationReader.getProperty("librarianUsername");
        String LibraPassword = ConfigurationReader.getProperty("librarianPassword");
        EmailAddressInput.sendKeys(LibraUsername);
        PasswordInput.sendKeys(LibraPassword);
        SignInButton.click();

    }

    public void StudentLogin(){
        String StudentUsername= ConfigurationReader.getProperty("studentUsername");
        String Studentpassword = ConfigurationReader.getProperty("studentPassword");
        EmailAddressInput.sendKeys(StudentUsername);
        PasswordInput.sendKeys(Studentpassword);
        SignInButton.click();

    }
}
