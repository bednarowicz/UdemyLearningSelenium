package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPage {
    private WebDriver driver;
    @FindBy(name = "register")
    private WebElement submitSignUp;
    @FindBy(id = "reg_email")
    private WebElement signUpReqEmailInput;
    @FindBy(id = "reg_password")
    private WebElement signUpReqPasswordInput;
    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public LoggedUserPage registerUser(String email, String password){
        signUpReqEmailInput.sendKeys(email);
        signUpReqPasswordInput.sendKeys(password);
        submitSignUp.click();
        return new LoggedUserPage(driver);
    }

}
