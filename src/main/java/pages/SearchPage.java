package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(xpath = "//input")
    private WebElement input;

    @FindBy(xpath = "//button")
    private WebElement button;

    @FindBy(id = "result")
    private WebElement result;
    public SearchPage (WebDriver driver){
        driver.navigate().to("http://localhost:3100/search");
        PageFactory.initElements(driver, this);
    }

    public WebElement getButton() {
        return button;
    }

    public WebElement getInput() {
        return input;
    }

    public WebElement getResult() {
        return result;
    }
}
