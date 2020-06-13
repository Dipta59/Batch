package Day05_04252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locate_By_Xpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");
        // define the driver

        WebDriver driver = new ChromeDriver();

        // navigate to amazon home page

        driver.navigate().to("https://www.amazon.com");

        //maximize your driver window
        driver.manage().window().maximize();

        //wait for a seconds

        Thread.sleep(2000);


        // enter a keyword laptop on amazon search field by using xpath

        driver.findElement(By.xpath("//*[@name='field-keywords' or @id ='twotabsearchtextbox']")).sendKeys("laptop");

        // click on search icon

        driver.findElement(By.xpath("//*[@type='submit' and @value='Go']")).submit();

        //wait for couple seconds
        Thread.sleep(2000);

        // click on the first item of the same elements within that page using index number
        //driver.findElements(By.xpath("//*[@class='s-image']")).get(1).click();
        //  "//*[contains(class, 's-image')"]

        driver.findElements(By.xpath("//img[contains(@class,'s-image')]")).get(2).click();





    }// end of main method
} // end of java class
