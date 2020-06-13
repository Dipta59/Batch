package Day07_05022020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Met_Life_Tabs {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        //set some pre condition using ChromeOptions
        ChromeOptions options =  new ChromeOptions();

        //set the arguments you want for the driver
        options.addArguments("start-maximized","incognito");

        // now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to met life home page
        driver.navigate().to("https://www.metlife.com/");
        Thread.sleep(4000);


        //click on solution tabs
        try {
            driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();
        } catch (Exception e){
            System.out.println("unable to click on solutions" + e);
        } // end of SOLUTIONS exceptions

        // put few seconds
        Thread.sleep(2000);


        try {
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
        }catch (Exception e) {
            System.out.println("unable to click on MetLife TakeAlong dental " + e);
        } // end of MetLife TakeAlong Dental exception
        Thread.sleep(3500);

        //click on enroll now
        try{
            driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
        }catch (Exception e) {
            System.out.println("Unable to click on Enroll now" + e);
        } // end of Enroll now exception

        // now define the ArrayList to handle all current window tabs that are open
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        // switch to second tab
        driver.switchTo().window(tabs.get(1));

        // enter you zipcode

        try{
            driver.findElement(By.xpath("//*[@id='txtZipCode']")).sendKeys("11218");
        } catch (Exception e ){
            System.out.println("Unable to enter on search Field " + e);
        } // end of zip code exception

        Thread.sleep(2000);

        // i want to close this tab
        driver.close();

        //switch to previous tab
        driver.switchTo().window(tabs.get(0));








    } // end of main method
} // end of java class
