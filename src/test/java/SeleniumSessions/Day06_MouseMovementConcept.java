package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Day06_MouseMovementConcept {
    public static void main (String [] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.hm.com/");

        Thread.sleep(2000);

        driver.findElement(By.linkText("United States (en)")).click();
        Thread.sleep(2000);

        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(By.linkText("Women"))).build().perform();

        driver.findElement(By.linkText("Jeans")).click();

        Thread.sleep(2000);

        driver.findElements(By.xpath("//*[@class='item-image']")).get(0).click();
        Thread.sleep(2000);


        driver.quit();














    }// end of main method

}// end of java class
