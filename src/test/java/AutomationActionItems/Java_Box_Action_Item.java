package AutomationActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Java_Box_Action_Item {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://faculty.washington.edu/chudler/java/boxes.html");
        Thread.sleep(2000);

        List <WebElement> checkbox = driver.findElements(By.xpath("//*[@type='checkbox']"));

        for(int i=0; i<checkbox.size(); i++){

            WebElement box = checkbox.get(i);
            box.click();




        } // end of for loop




    } // end of main method


} // end of java class
