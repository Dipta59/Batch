package AutomationActionItems;

import MetLife_Project.MetLife_Base_Class;
import MetLife_Project.MetLife_HomePage;
import Reusable_Class.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Metlife_Page_Object extends Abstract_Class {

    Workbook readableFile;

    Sheet readableSheet;

    WritableWorkbook writableFile;

    WritableSheet excelSheet;

    int rows;





    @Test
    public void Metlife_Page_Object() throws InterruptedException, IOException, BiffException, WriteException {


        readableFile = Workbook.getWorkbook(new File("src//main//resources//metlife.xls"));

        readableSheet = readableFile.getSheet(0);

        WritableWorkbook writableFile;
        writableFile = Workbook.createWorkbook(new File("src//main//resources//metlife_results.xls"),readableFile);

        excelSheet = writableFile.getSheet(0);

        rows = excelSheet.getRows();
        for(int i = 1; i<rows; i++) {

            String dentalprogram = excelSheet.getCell(0,i).getContents();

            String zipcode = excelSheet.getCell(1,i).getContents();

            String referralCode = excelSheet.getCell(2,i).getContents();

            String message = excelSheet.getCell(3,i).getContents();

            String captureMessage = excelSheet.getCell(4,i).getContents();


            logger.log(LogStatus.INFO, "navigating to metlife page");
            driver.navigate().to("https://www.metlife.com");
            Thread.sleep(2000);

            MetLife_Base_Class.metLife_homePage().solutions();

            MetLife_Base_Class.metLife_homePage().takeAlongDental();

            MetLife_Base_Class.metlife_enroll().enroll();

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(1));

            MetLife_Base_Class.metlife_zipcode().SearchBox(zipcode);

            MetLife_Base_Class.metlife_zipcode().clickgo();

            MetLife_Base_Class.metLife_dental_program().gettingDP(dentalprogram);

            MetLife_Base_Class.metLife_dental_program().clickingEnroll();
            Thread.sleep(4000);


            MetLife_Base_Class.metLife_dental_program().refCode(referralCode);

            MetLife_Base_Class.metLife_dental_program().clickgo();

            String result = MetLife_Base_Class.metLife_dental_program().getText();

            MetLife_Base_Class.metLife_dental_program().clickgo2();

            String results = MetLife_Base_Class.metlife_ppo().searchPage();

            Label label = new Label(4,i,results);

            excelSheet.addCell(label);

            driver.close();

            driver.switchTo().window(tabs.get(0));



        } // end of for loop
        writableFile.write();
        writableFile.close();
        readableFile.close();
     } // end of test


} // end of java class
