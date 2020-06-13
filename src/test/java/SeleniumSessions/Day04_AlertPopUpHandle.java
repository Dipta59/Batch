package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day04_AlertPopUpHandle {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver83.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://rediff.com");
        Thread.sleep(2000);

        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@name='proceed']")).click();  // clicking on sign in

        Thread.sleep(2200);

        Alert alert = driver.switchTo().alert();    

        System.out.println(alert.getText());

        String text = alert.getText();
        if(text.equals("Please enter a valid user name")){
            System.out.println("correct alert message");
        } else {
            System.out.println("incorrect alert message ");
        }

        alert.accept(); // click on okay button

        // alert.dismiss(); // click on cancel button




    } // end of main method
}// end of java code
