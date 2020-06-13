package Day10_05102020;

import Reusable_Class.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Excel_Google_Search {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {


        //Step 1 :
        //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src//main//resources//google.xls"));

        //Step 2:
        //locate the readable worksheet
        Sheet readableSheet = readableFile.getSheet(0);

        //Step 3 :
        // we need to create a writable workable to mimic readable file because we shouldn't be writing on readable file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src//main//resources//google_result.xls"),readableFile);

        // create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);
        //get the total rows that are not empty
        int rows = writableSheet.getRows();

        //define the web driver using resuable library

        WebDriver driver = Reusable_Library.setDriver();

        // define the for loop

        for(int i = 1; i<rows; i++){

            Thread.sleep(1000);

            //step 4
            // store the cars column values as a String variable
            //column are always hard coded whereas the rows are dycmic based on your I
            String category = writableSheet.getCell(0,i).getContents();


            // navigate to google page
            driver.navigate().to("https://www.google.com");
            //timeout
            Thread.sleep(2000);


            //resuable library to enter car values on search field
            Reusable_Library.userKeys(driver,"//*[@name='q']",category,"Search Field");


            //reusbale library to click on google search
            Reusable_Library.submit(driver,"//*[@name='btnK']","Google Search");

            //timeout
            Thread.sleep(2000);

            String result = Reusable_Library.captureText(driver,"//*[@id='result-stats']","search Results");
            String [] resultArray = result.split(" ");
            System.out.println("My search number is " + resultArray [1]);

            //Step 5:
            //write the search number result back to writable sheet
            Label label = new Label(1,i,resultArray[1] + " " + resultArray[3] + " " + resultArray[4]) ;
            //adding back to writable cell
            writableSheet.addCell(label);

        }// end of for loop

        //outside of loop we need to write and close the excel
        writableFile.write();
        writableFile.close();
        readableFile.close();
















    } // end of main method
} // end of java class
