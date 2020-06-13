package AutomationActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AL3 {
    public static void main(String[] args) throws InterruptedException {
        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver83.exe");

        //set some pre condition using ChromeOptions
        ChromeOptions options = new ChromeOptions();

        //set the arguments you want for the driver
        options.addArguments("start-maximized", "incognito");

        // now simply define you chrome driver
        WebDriver driver = new ChromeDriver(options);

        String[] zipcode = new String[3];
        zipcode[0] = "11222";
        zipcode[1] = "11201";
        zipcode[2] = "11255";
        for (int i = 0; i < zipcode.length; i++) {

            // navigate to weightwatchers.com
            driver.navigate().to("https://www.weightwatchers.com");

            //wait for 2 seconds
            Thread.sleep(3000);
            // finding the Title ( if the title is wrong then it will come in else condition ... if the title is right it will come in if condition )
            String Title = driver.getTitle();
            if (Title.equals("WW (Weight Watchers): Weight Loss & Wellness Help")) {
                System.out.println("title matches with expected");
            } else {
                System.out.println("Title doesn't match " + Title);
            }

            // click on find the workshop
            driver.findElement(By.linkText("Find a Workshop")).click();


            Thread.sleep(3000);

            // type the zipcode
            driver.findElement(By.xpath("//*[@name='meetingSearch']")).sendKeys(zipcode[i]);
            //  enter
            driver.findElement(By.xpath("//*[@type='button']")).click();

            if (i == 0) {  // zipcode 1

                driver.findElements(By.xpath("//*[@class='meeting-locations-list__item']")).get(1).click();
            } // end of if condition


            if (i == 1) { // zipcode 2
                driver.findElements(By.xpath("//*[@class='meeting-locations-list__item']")).get(2).click();
            } // end of if condition


            if (i == 2) { // zipcode 3
                driver.findElements(By.xpath("//*[@class='meeting-locations-list__item']")).get(0).click();

            } // end of if condition

            // Address for the store
            String Message = driver.findElement(By.xpath("//*[@class='location']")).getText();
            System.out.println("My Address is " + Message);

            // Schedule Chat
            String Chat = driver.findElement(By.xpath("//*[@class='meeting-schedule__schedule']")).getText();
            System.out.println("My Schedule are " + Chat);


            Thread.sleep(2000);


        } // end of for loop

        driver.quit();


    } // end of main method
} // end of java code
