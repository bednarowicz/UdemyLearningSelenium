package pl.testeroprogramowania.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.AddressDetailsPage;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkOutTest(){
        Customer customer = new Customer();

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openMyShop()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewChart()
                .openAddressDetails()
                .fillAddressDetails(customer,"some random comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(),"Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(),"Java Selenium WebDriver × 1");
    }
}
