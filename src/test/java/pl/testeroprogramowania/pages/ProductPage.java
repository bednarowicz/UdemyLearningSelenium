package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;
    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    private WebElement viewChartButton;
    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;
    public ProductPage addProductToCart(){
        addToCartButton.click();
        return this;
    }
    public CartPage viewChart(){
        viewChartButton.click();
        return new CartPage(driver);
    }
}
