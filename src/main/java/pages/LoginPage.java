package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "signin-button")
    private WebElement signInButton;
    @FindBy(id = "message")
    private WebElement errorMessage;

    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }
}
