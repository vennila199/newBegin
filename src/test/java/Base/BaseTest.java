package Base;

import DriverFactory.BrowserDriverFactory;
import DriverFactory.WebDriverFactory;
import POJO.BillingAddress;
import Utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class BaseTest {
    public WebDriver driver;
    public BrowserDriverFactory browserDriverFactory;
    @Parameters({"browser"})
    @BeforeMethod
    public  synchronized void  getWebdriverfromFactory(@Optional("chrome") String browser)
    {
        browserDriverFactory=new BrowserDriverFactory(browser);
        browserDriverFactory.createDriver();
       driver= browserDriverFactory.getDriver();
//       driver= WebDriverFactory.getDriver();
//
//        driver.manage().window().maximize();
    }


    @AfterMethod
    public void closeDriver()
    {
     //  browserDriverFactory.quitDriver();
        WebDriverFactory.quitDriver();
    }

    @DataProvider(name="fillform", parallel = true)
    public static Iterator<BillingAddress> getData() throws IOException {
        List<LinkedHashMap<String, String>> exceldata=  ExcelUtils.getExcelData("winterTestData","customerDetails");
        List<BillingAddress> billingAddressList=new ArrayList<>();
        for(LinkedHashMap<String,String> data:exceldata)
        {
            BillingAddress billingAddress=new BillingAddress();
                billingAddress.setFirstName(data.get("firstName"));
                billingAddress.setLastName(data.get("LastName"));
                billingAddress.setPostalCode(data.get("PostalCode"));
            billingAddressList.add(billingAddress);
        }
//
//        return new Object[][]{
//                {"Awe","some","627359"},
//                {"meow","kutty","67890"},
//                {"wer","are","89076"}
//        };
        return billingAddressList.iterator();
    }

}
