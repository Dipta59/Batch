package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day11_Navigation {
    public static void main(String[] ags) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        // driver.get() vs driver.navigate().to()

        driver.navigate().to("https://www.google.com");
            Thread.sleep(2000);

        driver.navigate().to("https://www.amazon.com");

        // back and forward buttons simulation
        driver.navigate().back();

        driver.navigate().forward();
        // to Refresh the page
        driver.navigate().refresh();







    } // end of main method
} // end of java code
