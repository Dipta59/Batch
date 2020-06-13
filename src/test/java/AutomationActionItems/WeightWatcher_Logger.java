package AutomationActionItems;

import Reusable_Class.Abstract_Class;
import Reusable_Class.Reusable_Library_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WeightWatcher_Logger extends Abstract_Class {


        @Test
        public void weightWatcher() throws InterruptedException {


        String[] zipcode = new String[3];
        zipcode[0] = "11222";
        zipcode[1] = "11201";
        zipcode[2] = "11255";
        for (int i = 0; i < zipcode.length; i++) {

            // navigate to weightwatchers.com
            logger.log(LogStatus.INFO,"navigating to weightwatchers");
            driver.navigate().to("https://www.weightwatchers.com");

            //wait for 2 seconds
            Thread.sleep(3000);
            // finding the Title ( if the title is wrong then it will come in else condition ... if the title is right it will come in if condition )

            Reusable_Library_Logger.verifyTitle(driver,"WW (Weight Watchers): Weight Loss & Wellness Help");


            // click on find the workshop
            Reusable_Library_Logger.click2(driver,"Find a Workshop","clicking on workshop", logger);



            Thread.sleep(3000);

            // type the zipcode
            Reusable_Library_Logger.userKeys(driver,"//*[@name='meetingSearch']",zipcode[i],"search",logger);

            //  enter
            Reusable_Library_Logger.click(driver,"//*[@type='button']", "enter",logger);

            if (i == 0) {  // zipcode 1

                Reusable_Library_Logger.clickByIndex(driver,"//*[@class='meeting-locations-list__item']",1,"Null",logger );

            } // end of if condition


            if (i == 1) { // zipcode 2
                Reusable_Library_Logger.clickByIndex(driver,"//*[@class='meeting-locations-list__item']",2,"NUll",logger);
            } // end of if condition


            if (i == 2) { // zipcode 3
                Reusable_Library_Logger.clickByIndex(driver,"//*[@class='meeting-locations-list__item']",0,"NUll",logger);

            } // end of if condition

            // Address for the store

            Reusable_Library_Logger.captureText(driver,"//*[@class='location']","Getting text",logger);



            // Schedule Chat

            Reusable_Library_Logger.captureText(driver,"//*[@class='meeting-schedule__schedule']","getting Schedule chat",logger);


            Thread.sleep(2000);


        } // end of for loop




    } // End of Test
} // end of java code
