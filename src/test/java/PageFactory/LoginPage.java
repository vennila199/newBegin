package PageFactory;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
//    By user_id=By.xpath("//input[@placeholder='Username']");
//    By  user_password=By.xpath("//input[@placeholder='Password']");

    @FindBy(xpath ="//input[@placeholder='Username']" ) private WebElement user_id;
    @FindBy(xpath = "//input[@placeholder='Password']") private WebElement password;
    @FindBy(id = "login-button") private WebElement buttonLogin;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void getURL()
    {
        load();
    }

    public void Login()
    {
        user_id.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        buttonLogin.click();
    }


}
