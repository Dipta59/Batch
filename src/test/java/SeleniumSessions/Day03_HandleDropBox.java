package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Day03_HandleDropBox {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);

        //handle drop box
        Select select = new Select(driver.findElement(By.id("fpdd")));
        select.selectByVisibleText("May");
        select.selectByVisibleText("Jun");



        Thread.sleep(2000);


        driver.quit();













    } // end of main method


} // end of java class
