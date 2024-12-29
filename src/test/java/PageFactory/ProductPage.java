package PageFactory;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends BasePage {
    @FindBy(xpath ="//div[@class=\"inventory_item\"]" ) private  List<WebElement>  inventory_items;
    @FindBy(className = "inventory_item_name") private WebElement item;
    @FindBy(className= "btn_primary") private WebElement buttonAddtoCart;
    @FindBy(xpath= "//a[contains(@href, './cart.html')]") private WebElement iconAddtoCart;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void AddtoCart(String productName)
    {

       // List<WebElement> items=driver.findElements(By.xpath("//div[@class=\"inventory_item\"]"));
        for(WebElement ele:inventory_items)
        {
            WebElement child= ele.findElement(By.className("inventory_item_name"));
            if(child.getText().equalsIgnoreCase(productName))
            {
                System.out.println(child.getText());
                WebElement element=ele.findElement(By.className("btn_primary"));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                ele.findElement(By.className("btn_primary")).click();
            }
        }


    }
    public void AddtoCartThroughStreamAPI(String ProductName)
    {
        List<WebElement> items=driver.findElements(By.xpath("//div[@class='inventory_item']"));
        items.stream().filter(e->e.findElement(By.className("inventory_item_name")).getText()
                        .equalsIgnoreCase(ProductName))
                .forEach(ele->ele.findElement(By.className("btn_primary")).click());
    }

    public void clickAddtocartIcon()
    {
        iconAddtoCart.click();
    }



}
