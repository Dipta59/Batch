package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Day07_DragAndDropConcept {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.google.com");
        Thread.sleep(1200);

        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("drag and drop");
        Thread.sleep(1200);

        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        driver.navigate().to("https://jqueryui.com/");
        Thread.sleep(2500);
        driver.findElement(By.linkText("Droppable")).click();


        Thread.sleep(1500);

        driver.switchTo().frame(0); //switch to frame if its present


        Actions action = new Actions(driver);

        action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']"))).moveToElement(driver.findElement(By.xpath("//*[@id='droppable']"))).release().perform();



















    } // end of main method


}// end of java code
