package com.cybertek.library.step_definitions;


import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinition {

   LoginPage loginPage = new LoginPage();  //creating loginpage in class level because if we create in the method
                                          // we are not able to use it in other method

    LandingPage landingPage =new LandingPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {

        String URL = ConfigurationReader.getProperty("Url");
        Driver.getDriver().get(URL);

    }

    @When("User logs in as a librarian")
    public void user_logs_in_as_a_librarian() {

        loginPage.LibrarianLogin();
       System.out.println(Driver.getDriver().getTitle());




    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expectedResult = "dashboard";


        // create webdriver wait.  move this condition before the actual bc we waited to get URL that contain "dashboard"
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(expectedResult));

        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expectedResult));

        Driver.closeDriver();


    }

    @When("User logs in as a student")
    public void userLogsInAsAStudent() {

          loginPage.StudentLogin();
          System.out.println(Driver.getDriver().getTitle());

    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {
        String expectedResult= "books";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(expectedResult));
        String acturalResult= Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(acturalResult.contains(expectedResult));

    }
    @When("user enter username {string}")
    public void user_enter_username(String string) {

        String username = string;
        loginPage.EmailAddressInput.sendKeys(username);
    }




    @When("user enter password {string}")
    public void user_enter_password(String string) {
        String password = string;
        loginPage.PasswordInput.sendKeys(password);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.SignInButton.click();

    }
    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {
        int expectedUserNum = int1;
        String expected = String.valueOf(expectedUserNum); // this way we can get string value of the int

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(landingPage.UserCount));

        String actualUser = landingPage.UserCount.getText();

        Assert.assertEquals("actual not matching with expected",actualUser,expected);




    }



}
