package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        WebDriverManager.chromedriver().setup(); return new ChromeDriver(); });

    public static WebDriver getDriver() { return driver.get(); }

    public static void quitDriver() { if (driver.get() != null) { driver.get().quit(); driver.remove(); } }
}