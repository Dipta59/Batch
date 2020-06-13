package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day02_LocatorConcept {
    public static void main( String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://google.com");

        // 1. xpath :
        //absolute xpath should not be used        ------ html/body/div[1]/div[5]/div[2]/a
        //only relative xpath should be used
        // 2. ID :
        // 3. Name :
        // 4. LinkText --- driver.findElement(By.linkText(Sign in)).click();         (only for Links)
        // 5. partial Link -- not useful  (only for links)
        // 6. CSSelector
        // if id is there #(id)
        // if class is there -- .(class)
        // 7. Class (not useful)
        // 8.


        try {
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Amazon");
        }catch (Exception e){
            System.out.println("Unable to type amazon on thr search box " + e);
        } // unable to type on the search box
        try {
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        } catch(Exception e) {
            System.out.println("Unable press on the search box " + e);
        } // Submit box for google

        Thread.sleep(2000);
        try{
            driver.findElements(By.xpath("//*[contains(@class, 'DKV0Md')]")).get(0).click();
        } catch(Exception e){
            System.out.println ("unable to click on the link" + e);
        }// clicking on the first link

        Thread.sleep(2000);
        try{
            driver.findElement(By.linkText("Sign in")).click();
        } catch (Exception e){
            System.out.println("unable to click on account sign in " + e);
        } // clicking on sign in account
        Thread.sleep(1000);

        try {
            driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("Dipta619@yahoo.com");
        } catch (Exception e){
            System.out.println(" unable to enter The email" + e);
        } // First name

        try {
            driver.findElement(By.xpath("//*[@id='continue']")).click();
        } catch (Exception e) {
            System.out.println("unable to click on continue" + e);
        } // clicking on continue button











    }// end of main method


}// end of java class
