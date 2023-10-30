package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckout;
    private WebDriver driver;
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public AddressDetailsPage openAddressDetails(){
        proceedToCheckout.click();
        return new AddressDetailsPage(driver);
    }
}
