package SeleniumSessions;

import com.sun.jdi.PathSearchingVirtualMachine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_FindElementsConcept {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver83.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");

        WebDriver driver = new ChromeDriver(options);



        driver.navigate().to("https://www.ebay.com");
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@name='_nkw']")).sendKeys("Cricket Bat");

       driver.findElement(By.xpath("//*[contains(@id,'gh-btn')]")).click();

        Thread.sleep(1500);

        //get the total count of links on the page
        //get the text of each links on the page

        // all the links are represented by <a> html tag:

        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        // size of linkList:
        System.out.println(linkList.size());

        for(int i=0; i<linkList.size(); i++){
           String linkText = linkList.get(i).getText();
            System.out.println(linkText);
        } // end of for loop












    }// end of main method
} // end of java code
