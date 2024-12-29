package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public String browser;
    public BrowserDriverFactory(String browser)
    {
        this.browser=browser;
    }
    public void createDriver()
    {
        switch (browser)
        {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "");
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "");
                driver.set(new ChromeDriver());

        }
        System.out.println("create Driver Thread ID: " + Thread.currentThread().getId() + " - Title: " + driver.get().getTitle());

    }

    public  WebDriver getDriver() {
        System.out.println("get Driver Thread ID: " + Thread.currentThread().getId() + " - Title: " + driver.get().getTitle());
        return driver.get();
    }

   // private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> { WebDriverManager.chromedriver().setup(); return new ChromeDriver(); })

    public  void quitDriver() {
        System.out.println("quit Driver Thread ID: " + Thread.currentThread().getId() + " - Title: " + driver.get().getTitle());

        if (driver.get() != null)
          {
            driver.get().quit(); driver.remove(); }
    }


}
