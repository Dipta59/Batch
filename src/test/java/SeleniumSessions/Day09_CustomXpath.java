package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Day09_CustomXpath {
    public static void main(String[] ags) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.ebay.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Thread.sleep(2000);


        // Absolute xpath not recommended
        // 1. performance issue
        //2. not reliable
        //3. can be changed at any time in future

        driver.findElement(By.xpath("//*[@name='_nkw']")).sendKeys("Cricket Bat");

       // driver.findElement(By.xpath("//*[contains(@id,'gh-btn')]")).click();
        // dynamic ID (Its keep changing)
        //By.id = test123
        //By.iD = test 234
        //By.id = test 345
        // you can only use (starts with) beginning of the property if its the same each time

        driver.findElement(By.xpath("//*[starts-with(@id,'gh-b')]")).click();
        Thread.sleep(2000);

        //for links custom xpath
        // all the links are represented by <a> html tag:
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='geetest_radar_tip']")).click();












    } // end of main method
} // end of java class
