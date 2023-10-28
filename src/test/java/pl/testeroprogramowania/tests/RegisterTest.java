package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {
    @Test
    public void registerUserTest(){

        int randomNumber = (int) (Math.random()*100000);
        String email = "testowyMail" + randomNumber + "@wp.com";

        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData(email, "testowyMail@wp.com")
                .getDashBoard();
        Assert.assertTrue(entryTitle.isDisplayed());
        Assert.assertEquals(entryTitle.getText(), "Dashboard");
    }
    @Test
    public void registerUserTestWithTheSameName(){

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("testowyMail@wp.com", "testowyMail@wp.com")
                .getError();
        Assert.assertTrue(error.isDisplayed());
        Assert.assertTrue(error.getText().contains(" account is already registered with your email"));
    }
}
