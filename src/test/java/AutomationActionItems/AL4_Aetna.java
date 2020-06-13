package AutomationActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;


public class AL4_Aetna {
    public static void main( String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> zip = new ArrayList<>();
        zip.add("11218");
        zip.add("11220");
        zip.add("11201");


        ArrayList<Integer> Mile = new ArrayList<>();
        Mile.add(40);
        Mile.add(50);
        Mile.add(60);

        for(int d =0; d<3; d++) {
        driver.navigate().to("https://www.aetna.com/");

       String title = driver.getTitle();
       if (title.equals("Health Insurance Plans | Aetna")) {
           System.out.println("Title is correct" );
       } else {
           System.out.println("Title is Wrong " + title);
       } // getting the title using if and else condition
        Thread.sleep(4000);

           try {
               driver.findElement(By.xpath("//button[contains(text(),'Shop for a plan')]")).click();
           } catch (Exception e) {
               System.out.println("unable to click on shop for a plan" + e);
           } // Shop for a plan


           try {
               driver.findElement(By.xpath("//button[contains(text(),'Medicare')]")).click();
           } catch (Exception e) {
               System.out.println(" unable to click on Medicare " + e);
           } // clicking on medicare

           try {
               driver.findElement(By.linkText("Find a doctor")).click();
           } catch (Exception e) {
               System.out.println("Unable to click on find a doctor " + e);
           } // clicking on find a doctor


           Thread.sleep(12000);

           try {
               driver.findElement(By.xpath("//button[contains(@class,'BtnWidth mgbutton')]")).click();
           } catch (Exception e) {
               System.out.println(" Unable to click on 2020 Medicare plans you purchase yourself " + e);
           } // clicking on 2020 Medicare plans you purchase yourself


           try {
               WebElement zipcode = driver.findElement(By.xpath("//*[@id='medZip']"));
               zipcode.clear();
               zipcode.sendKeys(zip.get(d));
           } catch (Exception e) {
               System.out.println("Unable to entry zipcode " + e);
           } // zipcode

           Thread.sleep(5000);

           try {

               driver.findElement(By.xpath("//a[contains(@ng-attr-title,'{{match.label}}')]")).click();
           } catch (Exception e) {
               System.out.println("unable to click on drop down box" + e);
           } // Drop box

           Thread.sleep(2000);
           try {
               WebElement slider = driver.findElement(By.xpath("//*[contains(@class,'rz-pointer')]"));
               Actions action = new Actions(driver);
               action.click(slider).build().perform();
               Thread.sleep(1000);
               for (int i = 0; i < 25; i++) {
                   action.sendKeys(Keys.ARROW_LEFT).build().perform();
               } //
               for (int i = 0; i < Mile.get(d); i++) {
                   action.sendKeys(Keys.ARROW_RIGHT).build().perform();
               } // end of loop
           } catch (Exception e) {
               System.out.println("unable to move the slider " + e);
           } // moving the slider

           Thread.sleep(1000);
           try {
               driver.findElements(By.xpath("//*[contains(@class,'primaryPurple BtnWidth c')]")).get(1).click();
           } catch (Exception e) {
               System.out.println("Unable to click on skip plan " + e);
           } // skip plan

           Thread.sleep(2000);

           try {
               driver.findElement(By.linkText("Medical Doctors & Specialists")).click();
           } catch (Exception e) {
               System.out.println("unable to click on Medical Doctors & Specialists" + e);
           } // clicking on Medical Doctors & Specialists

           Thread.sleep(1000);
           try {
               driver.findElement(By.linkText("Doctors (Primary Care)")).click();
           } catch (Exception e) {
               System.out.println("unable to click Doctors (Primary Care)" + e);
           } // clicking on Doctors (Primary Care)

           Thread.sleep(1000);
           try {
               driver.findElement(By.xpath("//*[contains(@class,'focusForIE')]")).click();
           } catch (Exception e) {
               System.out.println("unable to clicking on all Primary care physicians " + e);
           } // clicking on ll Primary care physicians

           Thread.sleep(6000);

           String Doctor = driver.findElements(By.xpath("//*[contains(@class, 'FontForMobile')]")).get(0).getText();
           String Address = driver.findElements(By.xpath("//*[contains(@class, 'DisplayForAddress')]")).get(0).getText();

           System.out.println("The Doctor name " + Doctor + " And the Address is " + Address);


       } // end of for loop


    } // end of main method

} // end of java code
