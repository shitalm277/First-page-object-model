package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager extends BasePage {
    String browserName = "Chrome";
    LoadProp loadProp = new LoadProp();

    public void openBrowser(){
        if (browserName.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("edge"))
        {
            System.setProperty("webdriver.edge.driver" , "src/test/java/Drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver" , "src/test/java/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else
        {
            System.out.println("Your Browser name is Wrong");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        //driver.get("https://demo.nopcommerce.com/");
        driver.get (loadProp.getProperty("url"));
    }

    public void closeBrowser()
    {
        driver.close();
    }
}
