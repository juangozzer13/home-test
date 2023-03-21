package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GridPage {

    @FindBy(id = "menu")
    private WebElement menu;
    @FindBy(xpath = "//label[@data-test-id='card-number'][text()='7']/ancestor::div/h4/b")
    private WebElement cardNumber7;
    @FindBy(xpath = "//label[@data-test-id='card-number'][text()='7']/ancestor::div/p" )
    private WebElement cardNumber7price;

    @FindBy(xpath = "//div[@class='item']")
    private List<WebElement> items;

    @FindBy(xpath = "//div[@class='item']/img")
    private List<WebElement> itemsImg;

    @FindBy(xpath = "//div[@class='item']/h4")
    private List<WebElement> itemsTitle;

    @FindBy(xpath = "//div[@class='item']/button")
    private List<WebElement> itemsButton;

    @FindBy(xpath = "//div[@class='item']/p")
    private List<WebElement> itemsPrice;



    public GridPage (WebDriver driver){
        driver.navigate().to("http://localhost:3100/grid");
        PageFactory.initElements(driver, this);
    }

    public WebElement getCardNumber7() {
        return cardNumber7;
    }

    public WebElement getMenu() {
        return menu;
    }

    public WebElement getCardNumber7price() {
        return cardNumber7price;
    }

    public List<WebElement> getItems() {
        return items;
    }
}
