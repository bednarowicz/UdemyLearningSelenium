package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {
    public LoggedUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
