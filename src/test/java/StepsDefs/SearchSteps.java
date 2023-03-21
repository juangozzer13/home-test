package StepsDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchPage;

public class SearchSteps {
    private final SearchPage searchPage = new SearchPage(Hooks.getDriver());

    @When("User is on search page")
    public void userIsOnSearchPage(){
        Hooks.waitForElement(searchPage.getButton());
    }

    @When("User search {string} in search bar")
    public void userSearchForAnyWordForInstanceAutomation(String arg0) {
        searchPage.getInput().sendKeys(arg0);
        searchPage.getButton().click();
    }

    @Then("User assert that {string} plus {string}.")
    public void userAssertThatPlusTheWordYouSearchedIsShown(String arg0, String arg1) {
        Hooks.waitForElementWithText(searchPage.getResult(),arg0 + " " + arg1);
        Assert.assertEquals(arg0 + " " + arg1, searchPage.getResult().getText());
    }

    @When("User leave search box empty and submit the search")
    public void userLeaveSearchBoxEmptyAndSubmitTheSearch() {
        searchPage.getButton().click();
    }

    @Then("User assert that {string} message is shown.")
    public void userAssertThatMessageIsShown(String arg0) {
        Hooks.waitForElementWithText(searchPage.getResult(),arg0);
        Assert.assertEquals(arg0, searchPage.getResult().getText());
    }
}
