package StepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.ReferenceNumberPage;

public class CheckoutSteps {

    private final CheckoutPage checkoutPage = new CheckoutPage(Hooks.getDriver());
    private final ReferenceNumberPage referenceNumberPage = new ReferenceNumberPage(Hooks.getDriver());

    @Given("User navigate to {string}")
    public void userNavigateToURL(String arg0){

    }

    @And("User verify that if {string} checkbox is checkmarked then uncheckmark it.")
    public void userVerifyThatIfCheckboxIsCheckmarkedThenUncheckmarkIt(String arg0) {
        if (checkoutPage.getCheckboxAgree().isSelected()){
            checkoutPage.getCheckboxAgree().click();
        }else{
            System.out.println("is already unchecked");
        }
    }

    @And("User verify that if {string} checkbox is not checkmarked then checkmark it.")
    public void userVerifyThatIfCheckboxIsNotCheckmarkedThenCheckmarkIt(String arg0) {
        if (checkoutPage.getCheckboxAgree().isSelected()){
            System.out.println("is already checked");
        }else{
            checkoutPage.getCheckboxAgree().click();
        }
    }

    @When("User submit the form")
    public void userSubmitTheForm() {
        checkoutPage.getSubmitButton().click();
    }

    @Then("User assert that the order confirmation number is not empty.")
    public void userAssertThatTheOrderConfirmationNumberIsNotEmpty() {
        Hooks.waitForElement(referenceNumberPage.getOrderNumber());
        Assert.assertTrue(referenceNumberPage.getOrderNumber().isDisplayed());
    }

    @Given("User is on checkout page")
    public void userIsOnCheckoutPage() {
        Hooks.waitForElement(checkoutPage.getFname());
        checkoutPage.getFname().isDisplayed();
    }

    @And("User verify that the alert message is shown.")
    public void userVerifyThatTheIsShown() {
        Assert.assertTrue(Hooks.driverGetAlertIsPresent());
    }

    @When("User confirm the alert")
    public void userConfirmTheAlert() {
        Hooks.driverAcceptAlert();
    }

    @Then("User assert that alert is gone.")
    public void userAssertThatAlertIsGone() {
        Assert.assertFalse(Hooks.driverGetAlertIsPresent());
    }

    @When("User is on checkout page again")
    public void userIsOnCheckoutPageAgain() {
        
    }

    @Then("User assert that the cart total shown is correct for the item prices added.")
    public void userAssertThatTheCartTotalShownIsCorrectForTheItemPricesAdded() {
        Hooks.waitForElement(checkoutPage.getFname());
        Assert.assertEquals(checkoutPage.getPrices(),checkoutPage.getTotalPrice());
    }

    @And("User Complete all the fields {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void userCompleteAllTheFields(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) {
        checkoutPage.getFname().sendKeys(arg0);
        checkoutPage.getCname().sendKeys(arg0);
        checkoutPage.getEmail().sendKeys(arg1);
        checkoutPage.getNum().sendKeys(arg2);
        checkoutPage.getAdress().sendKeys(arg3);
        checkoutPage.getExpMonth().sendKeys(arg4);
        checkoutPage.getCity().sendKeys(arg5);
        checkoutPage.getExpYear().sendKeys(arg6);
        checkoutPage.getCvv().sendKeys(arg7);
        checkoutPage.getState().sendKeys(arg5);
        checkoutPage.getZip().sendKeys(arg8);
    }
}
