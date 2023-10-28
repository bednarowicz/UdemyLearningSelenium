package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.ProductPage;

public class CheckoutTest extends BaseTest {
    @Test
    public void checkOutTest() {

        ProductPage entryTitle = new HomePage(driver)
                .openMyShop()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart();
    }
}
