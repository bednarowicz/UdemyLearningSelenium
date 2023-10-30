package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.testeroprogramowania.models.Customer;

public class AddressDetailsPage {
    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;
    @FindBy(id = "billing_last_name")
    private WebElement lasttNameInput;
    @FindBy(id = "billing_company")
    private WebElement companyNameInput;
    @FindBy(id = "billing_country")
    private WebElement billingCountrySelect;
    @FindBy(id = "billing_address_1")
    private WebElement billingAddress1stInput;
    @FindBy(id = "billing_address_2")
    private WebElement billingAddress2ndInput;
    @FindBy(id = "billing_postcode")
    private WebElement billingPostCodeInput;
    @FindBy(id = "billing_city")
    private WebElement billingCityInput;
    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;
    @FindBy(id = "billing_email")
    private WebElement billingEmailInput;
    @FindBy(id = "order_comments")
    private WebElement billingOrderCommentsInput;
    @FindBy(id ="place_order")
    private WebElement placeOrderButton;

    public OrderDetailsPage fillAddressDetails(Customer customer, String comments) {
        firstNameInput.sendKeys(customer.getFirstName());
        lasttNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        Select countrySelect = new Select(billingCountrySelect);
        countrySelect.selectByVisibleText(customer.getCountry());
        billingAddress1stInput.sendKeys(String.format("%s, %s", customer.getStreet(), customer.getFlatNumber()));
        billingPostCodeInput.sendKeys(customer.getZipCode());
        billingCityInput.sendKeys(customer.getCity());
        billingPhoneInput.sendKeys(customer.getPhone());
        billingEmailInput.sendKeys(customer.getEmail());
        billingOrderCommentsInput.sendKeys(comments);
        placeOrderButton.click();
        return new OrderDetailsPage(driver);
    }

    private WebDriver driver;
    public AddressDetailsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
