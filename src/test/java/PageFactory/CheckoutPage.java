package PageFactory;

import Base.BasePage;
import POJO.BillingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends BasePage {
    @FindBy(xpath ="//a[contains(text(),'CHECKOUT')]" ) private WebElement check_out;
    @FindBy(css= "input[placeholder=\"First Name\"]") private WebElement first_name;
    @FindBy(css= "input[placeholder=\"Last Name\"]") private WebElement last_name;
    @FindBy(css= "input[placeholder=\"Zip/Postal Code\"]") private WebElement postal;
    @FindBy(css= "input[value=\"CONTINUE\"]") private WebElement CONTINUE;
    @FindBy(xpath= "//a[contains(text(),'FINISH')]") private WebElement FINISH;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void clickCheckout()
    {
        check_out.click();
    }
    public void fillForm(BillingAddress billingAddress) {
        first_name.sendKeys(billingAddress.getFirstName());
        last_name.sendKeys(billingAddress.getLastName());
        postal.sendKeys(billingAddress.getPostalCode());
        CONTINUE.click();

    }
      public  void clickFinish()
      {
          FINISH.click();
      }

}