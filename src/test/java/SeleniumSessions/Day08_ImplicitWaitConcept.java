package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Day08_ImplicitWaitConcept {

    public static  void main(String[] args){

        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);


        driver.navigate().to("https://www.youtube.com");


        //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);


        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.findElement(By.xpath("(//*[@id='icon']) [2] ")).click();


        driver.findElement(By.xpath("(//*[contains(@class,'yt-simple-endpoint style-scope ytd-channel-list-sub-menu-avatar-renderer')]) [2]")).click();











    } // end of main method
}// end of java class
