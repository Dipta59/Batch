package Day08_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_Mortgage_Calculator {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        // set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");
        // now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://mortgagecalculator.org");

        Thread.sleep(2500);

        //declare and define javascript
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //scroll all the way to the bottom of the page
        //jse.executeScript("scroll(0,5000)");

        Thread.sleep(2000);
        // scroll all the way top of the page
        //jse.executeScript("scroll(0,-5000)");

        // scrolling to an element view for loan term
        try{
            WebElement loanTerm = driver.findElement(By.xpath("//*[@id='loanterm']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",loanTerm);
        } catch (Exception e) {
            System.out.println("unable to locate Loan Term" + e);
        } // end of try and catch












    } // end of main method
} // end of java class
