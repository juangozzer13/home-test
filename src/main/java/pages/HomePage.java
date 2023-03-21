package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//p[@data-id='username']")
    private WebElement messageUsernameHome;

    public HomePage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public WebElement getMessageUsernameHome() {
        return messageUsernameHome;
    }
}
