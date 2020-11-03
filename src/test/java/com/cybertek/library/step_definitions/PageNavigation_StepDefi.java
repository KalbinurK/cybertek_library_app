package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.UserPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageNavigation_StepDefi {

    UserPage userPage =new UserPage();
    LandingPage landingPage = new LandingPage();
    Select select;

    @When("User click on {string} link")
    public void user_click_on_link(String link) {

        BrowserUtils.waitForVisibility(landingPage.dashboardPageLink,5);
        switch (link.toLowerCase()){   //what ever we pass in the feature file, click that one we passed.
            case "dashboard":
                landingPage.dashboardPageLink.click();
                break;
            case "users"  :
                landingPage.UserPageLink.click();
                break;
            case "books":
                landingPage.bookPageLink.click();
                break;
        }


    }



    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {

        BrowserUtils.waitForVisibility(userPage.RecordDropdown,5);

        select = new Select(userPage.RecordDropdown);
         // get default options
        String actual =select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected+"",actual);

    }
    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        System.out.println("options = " + options);
        System.out.println("options size = " + options.size());


        select = new Select(userPage.RecordDropdown);

        List<WebElement> webElements = select.getOptions();
        List<String> actualTxt = BrowserUtils.getElementsText(webElements);

        Assert.assertEquals(options,actualTxt);

    }

}
