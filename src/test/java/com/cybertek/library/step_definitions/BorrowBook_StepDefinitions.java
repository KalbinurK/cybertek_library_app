package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class BorrowBook_StepDefinitions {

    LandingPage landingPage = new LandingPage();

    @And("User should sort by {string}")
    public void userShouldSortBy(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        landingPage.click_toSort();
    }

    @Then("User should able borrow book")
    public void userShouldAbleBorrowBook() throws InterruptedException {
        Thread.sleep(2000);
        landingPage.borrowBookClick();



    }


}
