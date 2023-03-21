package StepsDefs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;


public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(Hooks.getDriver());
    private final HomePage homePage = new HomePage(Hooks.getDriver());


    @Given("User is on login page")
    public void userlogin(){
        loginPage.getSignInButton().isDisplayed();
    }

    @When("User try to login with credentials: {string} {string}")
    public void successfullyLoginWithCredentials(String arg0, String arg1) {
        loginPage.getUsername().sendKeys(arg0);
        loginPage.getPassword().sendKeys(arg1);
        loginPage.getSignInButton().click();
    }

    @Then("User assert that welcome message containing username {string} is shown.")
    public void assertThatWelcomeMessageContainingUsernameIsShown(String arg0) {
        Hooks.waitForElement(homePage.getMessageUsernameHome());
        Assert.assertEquals(homePage.getMessageUsernameHome().getText(), arg0);
    }

    @Then("User assert error message is shown.")
    public void userAssertErrorMessageIsShown() {
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }
}
