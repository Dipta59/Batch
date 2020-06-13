package Day14_05312020;

import Reusable_Class.Abstract_Class;
import Reusable_Class.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class List_Boolean_Abstract extends Abstract_Class {


    @Test
    public void yahoo_verification() throws InterruptedException {
        //define and state the test
        logger = reports.startTest("yahoo verification");
        //navigate to yahoo home page
        logger.log(LogStatus.INFO,"Navigating to yahoo home page");

        driver.navigate().to("https://www.yahoo.com");
        // 3 or 4 seconds for page to load
        Thread.sleep(3500);

        logger.log(LogStatus.INFO,"getting the list count for all links");

        // i want to count all the links in yahoo homepage and print it
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px) Mstart(11px)')]"));
        System.out.println(linkCount.size());

        if(linkCount.size()== 12){
            System.out.println("My yahoo home page link count matches and it is " + linkCount.size());
            logger.log(LogStatus.PASS,"My yahoo home page link count matches and it is " + linkCount.size());
        } else {

            System.out.println("My yahoo home page link count doesn't matches and actual is " + linkCount.size());
            logger.log(LogStatus.FAIL,"My yahoo home page link count doesn't matches and actual is " + linkCount.size());
        } // end of if else
         //cliking on sign in
        Reusable_Library_Logger.click(driver,"//*[@id='header-signin-link']","sign In",logger);

        //wait few seconds

        Thread.sleep(3000);
        //verify the state of the checkbox for stay signed in section
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState == true){
            System.out.println("checkbox is selected by default");
            logger.log(LogStatus.PASS,"checking is selected by default");



        } else{
            System.out.println("Checkbox is not selected by default");
            logger.log(LogStatus.FAIL,"Checkbox is not selected by default");
        }



    } // end of test









} // end of java class
