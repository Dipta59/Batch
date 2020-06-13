package Day14_05312020;

import Reusable_Class.Reusable_Library;
import Reusable_Class.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_Logger {

    WebDriver driver;
    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet excelSheet;

    ExtentReports reports;
    // declare the logger(extent test)
    ExtentTest logger;



    @BeforeSuite
    public void defineDriver() throws IOException, BiffException, InterruptedException {
        //define the driver
        driver =Reusable_Library.setDriver();
        //defining the read able workbook path

        readableFile= Workbook.getWorkbook(new File("src//main//resources//Kayak.xls"));
        //define the sheet

        readableSheet= readableFile.getSheet(0);
        //define the writable work book path
        WritableWorkbook writableFile;
        writableFile= Workbook.createWorkbook(new File("src//main//resources//Kayak_results.xls"),readableFile);
        //defining writable sheet

        excelSheet= writableFile.getSheet(0);

        Thread.sleep(2000);


        reports = new ExtentReports("src//main//java//HTML_Report//Kayak_Report.html",true);



    }//end of before method



    @Test public void KayakTestCase() throws InterruptedException, WriteException {

        logger = reports.startTest("Kayak Test");

        int rows=excelSheet.getRows();
        for(int i=1; i<2;i++) {

            String airportName =excelSheet.getCell(0,i).getContents();
            String startDate = excelSheet.getCell(1,i).getContents();
            String startTime = excelSheet.getCell(2,i).getContents();
            String endDate = excelSheet.getCell(3,i).getContents();
            String endTime = excelSheet.getCell(4,i).getContents();
            String vehicleSize = excelSheet.getCell(5,i).getContents();
            String vehicleInfo = excelSheet.getCell(6,i).getContents();



            //navigate to web page
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(3000);
            //clicking on search box for airport
            Reusable_Library_Logger.click(driver, "//*[@data-placeholder='Enter an airport or city']", "airport",logger);
            //typing and entering Airpotname
            Reusable_Library_Logger.userTypeAndHitEnter(driver, "//*[@name='pickup']", airportName, "airportName",logger);
            //clicking on end date
            Reusable_Library_Logger.click(driver, "//*[@data-placeholder='Drop-off']", "end date",logger);
            Thread.sleep(2000);
            //entering the date

            Reusable_Library_Logger.userTypeAndHitEnter(driver, "(//*[@aria-label='Drop-off date']) [2]", endDate, "startingdate",logger);

            //endtime clicking
            Reusable_Library_Logger.click(driver, "(//*[@class='_id7 _irc _ii0 _iir']) [2]", "timeclick",logger);
            Thread.sleep(2000);

            //choosing the end time
            Reusable_Library_Logger.clickByIndex(driver, "//li[@aria-label='" + endTime + "']", 1,"endTime",logger);

            //clicking on start date
            Reusable_Library_Logger.click(driver, "//*[@data-placeholder='Pick-up']", "START DATE",logger);
            Thread.sleep(2000);


            //ENTERING START DATE

            Reusable_Library_Logger.userTypeAndHitEnter(driver, "(//*[@aria-label='Pick-up date'])[2]", startDate, "startDate",logger);
            Thread.sleep(2000);
            //clicking anywhere

            Reusable_Library_Logger.click(driver, "//*[@class='title dark']", "click anywhere",logger);
            Thread.sleep(1000);
            //click on start noon button
            Reusable_Library_Logger.click(driver, "(//*[@class='_id7 _irc _ii0 _iir']) [1]", "click on start noon",logger);
            Thread.sleep(2000);

            //choosing the starting time
            Reusable_Library_Logger.clickByIndex(driver, "//li[@aria-label='" + startTime + "']", 0,"startTime",logger);
            Thread.sleep(2000);

            //clicking on search icon box
            Reusable_Library_Logger.click(driver, "//*[@viewBox='0 0 54 54']", "search icon",logger);
            //clicking on checkbox
            Reusable_Library_Logger.click(driver, "(//*[contains(@class,'_idf _jAd _iji _ibc _jY2')])[2]",  "VehicleSize",logger);
            Thread.sleep(3000);
            //clicking view deals by using index method
            Reusable_Library_Logger.clickByIndex(driver, "//*[text()='View Deal']", 0, "car deals",logger);

            //define arraylist for a new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);
            //close the driver


            //capture text for the car
            String message = Reusable_Library_Logger.captureText(driver, "(//*[contains(@class,'Checkout-Common-Baselayout-R')or (@class='bui-panel   ') ])[5]", "vehicleInfo",logger);
            System.out.println("My car is " + message);

            //sending the message to excel
            Label Capturedmessage= new Label(6, i, message);
            excelSheet.addCell(Capturedmessage);

            driver.close();

            driver.switchTo().window(tabs.get(0));

            driver.manage().deleteAllCookies();


        }//end of loop
        reports.endTest(logger);
    }//end of test method

    @AfterSuite
    public void quitdriver() throws IOException, WriteException {
        reports.flush();
        writableFile.write();
        writableFile.close();
        readableFile.close();


driver.quit();
    }//end of after suite
}// end of java class
