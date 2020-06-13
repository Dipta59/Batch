package AutomationActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Yahoo_Action_Item {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='header-search-input']")).sendKeys("QA");

        driver.findElement(By.xpath("//*[@id='header-desktop-search-button']")).click();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Quality assurance - Wikipedia")).click();

        ArrayList<String>  tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2500);

        String message = driver.findElement(By.xpath("//*[@title='Middle Ages']")).getText();

        System.out.println("The message is " + message);

        driver.close();

        driver.switchTo().window(tabs.get(0));

        driver.quit();














    } // end of main method
} // end of java class
