package StepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GridPage;

public class GridSteps {

    private final GridPage gridPage = new GridPage(Hooks.getDriver());

    @When("User is on grid page")
    public void userIsOnGridPage(){
        Hooks.waitForElement(gridPage.getMenu());
    }

    @Then("User assert that in position 7 the product shown is {string}")
    public void userAssertThatInPositionTheProductShownIs(String arg1) {
        Assert.assertEquals(gridPage.getCardNumber7().getText(), arg1);
    }

    @And("User assert that the price shown is {string}")
    public void userAssertThatThePriceShownIs$(String arg0) {
        Assert.assertEquals(arg0, gridPage.getCardNumber7price().getText());
    }

    @Then("User assert that all the items have a non-empty title, price, image and a button.")
    public void userAssertThatAllTheItemsHaveANonEmptyTitlePriceImageAndAButton() throws InterruptedException {
        for (WebElement item : gridPage.getItems()){
            WebElement title = item.findElement(By.tagName("h4"));
            WebElement price = item.findElement(By.tagName("p"));
            WebElement image = item.findElement(By.tagName("img"));
            WebElement button = item.findElement(By.tagName("button"));
            Assert.assertNotNull(title);
            Assert.assertNotNull(price);
            Assert.assertNotNull(image);
            Assert.assertNotNull(button);
            Assert.assertTrue(title.getText().length() > 0);
            Assert.assertTrue(price.getText().length() > 0);
            Assert.assertTrue(image.getAttribute("src").length() > 0);
            Assert.assertTrue(button.getText().length() > 0);
        }
    }
}
