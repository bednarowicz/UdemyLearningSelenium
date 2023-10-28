package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class LogInTest extends BaseTest {
    @Test
    public void logInTest() {
        String email = "testowyMail@wp.com";

        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData(email, "testowyMail@wp.com")
                .getDashBoard();
        Assert.assertTrue(entryTitle.isDisplayed());
        Assert.assertEquals(entryTitle.getText(), "Dashboard");
    }

    @Test
    public void logInTestInvalidData() {

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInValidData("testowyMail@wpx.com", "testowyMail@wpdfdfssdf.com")
                .getError();
        Assert.assertTrue(error.isDisplayed());
        Assert.assertTrue(error.getText().contains("Incorrect username or password"), "Expected error text does not match");
    }
}
