package Test;

import Base.BaseTest;
import PageFactory.CartPage;
import PageFactory.LoginPage;
import PageFactory.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class checkURL extends BaseTest {
    @Test(enabled = true)
    public void StreamAPIcheckLogin()
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getURL();
        loginPage.Login();
        ProductPage productPage=new ProductPage(driver);
        productPage.AddtoCartThroughStreamAPI("Sauce Labs Bolt T-Shirt");
        productPage.clickAddtocartIcon();
        CartPage cartPage=new CartPage(driver);
        Assert.assertEquals(cartPage.getText(),"Sauce Labs Bolt T-Shirt");
    }
    @Test(enabled = true)
    public void traditionalcheckLogin2()
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.getURL();
        loginPage.Login();
        ProductPage productPage=new ProductPage(driver);
        productPage.AddtoCart("Sauce Labs Bolt T-Shirt");
        productPage.clickAddtocartIcon();
        CartPage cartPage=new CartPage(driver);
        Assert.assertEquals(cartPage.getText(),"Sauce Labs Bolt T-Shirt");
    }
}
