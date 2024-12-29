package Test;

import Base.BaseTest;
import DriverFactory.WebDriverFactory;
import POJO.BillingAddress;
import PageFactory.CheckoutPage;
import PageFactory.FinishPage;
import PageFactory.LoginPage;
import PageFactory.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;
public class AddtoCart  extends BaseTest {

    @Parameters({"firstName","LastName","postalCode"})
     @Test(enabled = false)
    public void testAddtocart(String firstName,String LastName,String postalCode)
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getURL();
        loginPage.Login();
        ProductPage productPage=new ProductPage(driver);
        productPage.AddtoCart("Sauce Labs Bolt T-Shirt");
        productPage.clickAddtocartIcon();
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.clickCheckout();
       // checkoutPage.fillForm(firstName,LastName,postalCode);
        checkoutPage.clickFinish();
        FinishPage finishPage=new FinishPage(driver);
        Assert.assertEquals(finishPage.getMessage(),"THANK YOU FOR YOUR ORDER");
    }

    @Test(dataProvider = "fillform")
    public void testAddtocartdataProviderStatic(BillingAddress billingAddress)
    {
        //WebDriver driver = WebDriverFactory.getDriver();
        WebDriver driver=browserDriverFactory.getDriver();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getURL();
        loginPage.Login();
        ProductPage productPage=new ProductPage(driver);
        productPage.AddtoCart("Sauce Labs Bolt T-Shirt");
        productPage.clickAddtocartIcon();
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.clickCheckout();
        checkoutPage.fillForm(billingAddress);
        checkoutPage.clickFinish();
        FinishPage finishPage=new FinishPage(driver);
        Assert.assertEquals(finishPage.getMessage(),"THANK YOU FOR YOUR ORDER");
    }

}
