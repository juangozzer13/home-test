package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {
    @FindBy(id = "cname")
    private WebElement cname;
    @FindBy(id = "ccnum")
    private WebElement num;
    @FindBy(id = "expmonth")
    private WebElement expMonth;
    @FindBy(id = "cvv")
    private WebElement cvv;
    @FindBy(id = "expyear")
    private WebElement expYear;
    @FindBy(id = "fname")
    private WebElement fname;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "adr")
    private WebElement adress;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "zip")
    private WebElement zip;
    @FindBy(id = "state")
    private WebElement state;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkboxAgree;
    @FindBy(xpath = "//button")
    private WebElement submitButton;
    @FindBy(xpath = "//p/a/ancestor::p/span[@class='price']")
    private List<WebElement> prices;
    @FindBy(xpath = "//p[text()='Total ']/span/b")
    private WebElement totalPrice;

    public CheckoutPage (WebDriver driver){
        driver.navigate().to("http://localhost:3100/checkout");
        PageFactory.initElements(driver, this);
    }

    public int getPrices() {
        int calculatedTotalPrice = 0;
        for (WebElement price : prices) {
            System.out.println(prices.size());
            String priceConverted = price.getText().replace("$", ""); // Remove the "$" symbol
            int num = Integer.parseInt(priceConverted); // Convert the string to an integer
            calculatedTotalPrice = calculatedTotalPrice + num;
        }
        return calculatedTotalPrice;
    }

    public WebElement getAdress() {
        return adress;
    }

    public WebElement getCheckboxAgree() {
        return checkboxAgree;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCname() {
        return cname;
    }

    public WebElement getCvv() {
        return cvv;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getExpMonth() {
        return expMonth;
    }

    public WebElement getExpYear() {
        return expYear;
    }

    public WebElement getFname() {
        return fname;
    }

    public WebElement getNum() {
        return num;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public int getTotalPrice() {
        String priceConverted = totalPrice.getText().replace("$", ""); // Remove the "$" symbol
        int num = Integer.parseInt(priceConverted); // Convert the string to an integer
        return num;
    }

    public WebElement getZip() {
        return zip;
    }
}
