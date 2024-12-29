package PageFactory;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FinishPage extends BasePage {
    @FindBy(xpath ="//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]" ) private  WebElement Order_Message;


    public FinishPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getMessage()
    {
     return Order_Message.getText();
    }

}
