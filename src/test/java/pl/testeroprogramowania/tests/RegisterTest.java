package pl.testeroprogramowania.tests;

import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {
    @Test
    public void registerUserTest(){
        new HomePage(driver).openMyAccountPage().registerUser("testowyMail@wp.com", "testowyMail@wp.com");
    }
}
