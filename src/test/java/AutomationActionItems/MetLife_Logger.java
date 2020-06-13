package AutomationActionItems;

import Reusable_Class.Abstract_Class;
import Reusable_Class.Abstract_Class_Parameter;
import Reusable_Class.Reusable_Library;
import Reusable_Class.Reusable_Library_Logger;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MetLife_Logger extends Abstract_Class {

    Workbook readableFile;

    Sheet readableSheet;

    WritableWorkbook writableFile;

    WritableSheet excelSheet;



    @Test
    public void metLife() throws InterruptedException, IOException, BiffException {

        readableFile = Workbook.getWorkbook(new File("src//main//resources//metlife.xls"));

        readableSheet = readableFile.getSheet(0);

        WritableWorkbook writableFile;
        writableFile = Workbook.createWorkbook(new File("src//main//resources//metlife_results.xls"), readableFile);

        excelSheet = writableFile.getSheet(0);
        int rows = excelSheet.getRows();
        for (int i = 1; i < rows; i++) {

            String dentalprogram = excelSheet.getCell(0, i).getContents();

            String zipcode = excelSheet.getCell(1, i).getContents();

            String referralCode = excelSheet.getCell(2, i).getContents();


            logger.log(LogStatus.INFO,"navigating to Metlife");
            driver.navigate().to("https://metlife.com");
            // verifying title

            Reusable_Library_Logger.verifyTitle(driver,"Insurance and Employee Benefits | MetLife");


            Thread.sleep(2500);


            Thread.sleep(2000);
            Reusable_Library_Logger.click(driver, "//div[contains(@class,'item-title font-eyebrow-1')]", "NUll", logger);


            Thread.sleep(1500);


            Reusable_Library_Logger.click(driver, "//*[contains(@href,'takealongdental')]", "NULL", logger);


            // verifying title
            Reusable_Library_Logger.verifyTitle(driver,"MetLife TakeAlong Dental | MetLife");


            Reusable_Library_Logger.click(driver, "//a[contains(@class,'2nd table')]", "2nd Table", logger);

            Thread.sleep(3000);


            // now define the arraylist to handle all current window tabs that are open
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(1));

            Reusable_Library_Logger.userKeys(driver, "//*[@id='txtZipCode']", zipcode, "Entering zipcode", logger);


            Reusable_Library_Logger.click(driver, "//*[@id='txtZipCodetxt']", "clicking on object", logger);


            Thread.sleep(6500);


            Reusable_Library_Logger.click(driver, "//*[@class='" + dentalprogram + "']", "dental", logger);

            Reusable_Library_Logger.click(driver, "//*[text()='ENROLL IN PROGRAM NOW']", "enroll in program", logger);


            Thread.sleep(2000);


            Reusable_Library_Logger.userKeys(driver, "//*[@class='form-control']", referralCode, "referal code", logger);

            Reusable_Library_Logger.click(driver, "//*[@id='enrollgobtn']", "catch go button", logger);

            Thread.sleep(1000);

            Reusable_Library_Logger.captureText(driver, "//*[@id='lblRefCodeError']", "print error", logger);


            Reusable_Library_Logger.click(driver, "//*[contains(@class,'primaryborder')]", "enroll now", logger);


            Thread.sleep(6000);


            Reusable_Library_Logger.captureText(driver, "//*[@class='col-sm-8']", "PPO", logger);


            String ppTYpe;
            if (dentalprogram.contains("PPO-High")) {
                ppTYpe = "PPO-LOW";
            } else {
                ppTYpe = dentalprogram;
            }
            driver.close();

            driver.switchTo().window(tabs.get(0));


            Thread.sleep(2000);

        }// end of for loop


    } // end of test
}// end of java code


