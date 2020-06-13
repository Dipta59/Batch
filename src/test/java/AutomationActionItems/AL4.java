package AutomationActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AL4 {
    public static void main(String[] args) throws InterruptedException {
        // set chrome path
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver83.exe");

        // adding pre options for your chrome
        ChromeOptions options = new ChromeOptions();

        // adding the options for your chrome
        options.addArguments("start-maximized", "incognito");

        ArrayList<String> dentalprogram = new ArrayList<>();

        dentalprogram.add("PPO-LOW");
        dentalprogram.add("PPO-MEDIUM");
        dentalprogram.add("PPO-HIGH");

        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11218");
        zipcode.add("11210");
        zipcode.add("11202");

        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("1234");
        referralCode.add("1237");
        referralCode.add("9111");


        // open chrome
        WebDriver driver = new ChromeDriver(options);


        for (int i = 0; i < 3; i++) {

            driver.navigate().to("https://metlife.com");
            // verifying title
            String title = driver.getTitle();
            if (title.equals("Insurance and Employee Benefits | MetLife")) {
                System.out.println("Correct Title");
            } else {
                System.out.println("Wrong Title " + title);
            } // end of title

            Thread.sleep(2500);


            Thread.sleep(2000);
            try {
                driver.findElement(By.xpath("//div[contains(@class,'item-title font-eyebrow-1')]")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on solutions " + e);
            } // end of try and catch solutions


            Thread.sleep(1500);

            try {
                driver.findElement(By.xpath("//*[contains(@href,'takealongdental')]")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on metlife dental");
            } // end of try and catch metlife dental
            Thread.sleep(1500);

            // verifying title
            String title1 = driver.getTitle();
            if (title1.equals("MetLife TakeAlong Dental | MetLife")) {
                System.out.println("correct Title");
            } else {
                System.out.println("Wrong Title " + title1);
            } // end of if and else condition


            try {
                driver.findElement(By.xpath("//a[contains(@class,'2nd table')]")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on enroll now" + e);
            } // end of try and catch enroll now
            Thread.sleep(3000);


            // now define the arraylist to handle all current window tabs that are open
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(1));

            try {
                WebElement zip = driver.findElement(By.xpath("//*[@id='txtZipCode']"));
                zip.clear();
                zip.sendKeys(zipcode.get(i));
            } catch (Exception e) {
                System.out.println("Unable to enter zipcode" + e);
            } // end of try and catch zipcode
            try {
                driver.findElement(By.xpath("//*[@id='txtZipCodetxt']")).click();
            } catch (Exception e) {
                System.out.println("Unable To click on go" + e);
            } // end of try and catch go


            Thread.sleep(6500);


            try {
                driver.findElement(By.xpath("//*[@class='" + dentalprogram.get(i) + "']")).click();
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(" unable able to do anything " + e);
            } // end of try and catch PPO !

            try {
                driver.findElement(By.xpath("//*[text()='ENROLL IN PROGRAM NOW']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on enroll in program now " + e);
            } // end of try and catch enroll in program now

            Thread.sleep(2000);


            try {
                driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys(referralCode.get(i));
            } catch (Exception e) {
                System.out.println("unable to type referralcode" + e);
            } // end of try and catch refeeralcode

            try {
                driver.findElement(By.xpath("//*[@id='enrollgobtn']")).click();
            } catch (Exception e) {
                System.out.println("unable to click on GO button " + e);
            } // end of try and catch go button

            Thread.sleep(1000);

            try {
                String message = driver.findElement(By.xpath("//*[@id='lblRefCodeError']")).getText();
                System.out.println(message);
            } catch (Exception e) {
                System.out.println("Unable to print " + e);
            }// end of try and catch print error

            try {
                driver.findElement(By.xpath("//*[contains(@class,'primaryborder')]")).click();
            } catch (Exception e) {
                System.out.println("Unable to click enroll now without referral code" + e);
            }// end of try and catch unable to click on enroll now without referral code

            Thread.sleep(6000);


            try {
                String ppo = driver.findElement(By.xpath("//*[@class='col-sm-8']")).getText();

                String ppTYpe;
                if (dentalprogram.get(i).contains("PPO-High")) {
                    ppTYpe = "PPO-LOW";
                } else {
                    ppTYpe = dentalprogram.get(i);
                }

                if (ppo.contains(ppTYpe)) {
                    System.out.println("print has a match " + ppo);
                } else {
                    System.out.println("print doesn't match " + ppo);
                } // end of if and else
            } catch (Exception e) {
                System.out.println("unable to print out ppo" + e);
            } // end of try and catch for print PPO

            Thread.sleep(2000);


            driver.close();

            driver.switchTo().window(tabs.get(0));


            Thread.sleep(2000);

        }// end of for loop


        driver.quit();


    } // end of main method
} // end of java class
