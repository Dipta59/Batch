package AutomationActionItems;

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

public class AL5 {
    public static void main (String [] args) throws InterruptedException, IOException, BiffException, WriteException {

        //Step 1
        //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src//main//resources//Express.xls"));

        //Step 2:
        //locate the readable worksheet
        Sheet readableSheet = readableFile.getSheet(0);

        //Step 3 :
        //we need to create a writable workable to mimic readable file we shouldn't be writing on readable file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src//main//resources//Express_result.xls"),readableFile);


        // create writable sheet
        WritableSheet writableSheet = writableFile.getSheet(0);
        //get the total rows that are not empty
        int rows = writableSheet.getRows();

        // define the web driver using resuable library
        WebDriver driver = Reusable_Library.setDriver();
        for(int i = 1; i<rows; i++) {

            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String streetAdd = writableSheet.getCell(6, i).getContents();
            String postalCode = writableSheet.getCell(7, i).getContents();
            String City = writableSheet.getCell(8, i).getContents();
            String State = writableSheet.getCell(9, i).getContents();
            String CreditCardNumber = writableSheet.getCell(10, i).getContents();
            String expirtationMonth = writableSheet.getCell(11, i).getContents();
            String ExYear = writableSheet.getCell(12, i).getContents();
            String cvvCode = writableSheet.getCell(13, i).getContents();
            String ErrorMessage = writableSheet.getCell(14, i).getContents();


            driver.navigate().to("https://www.express.com/");
            Thread.sleep(2000);

            Reusable_Library.mouseHover(driver, "//*[contains(@role,'menuitem')]", "Hover Mouse");

            Reusable_Library.click(driver, "//*[text()='Dresses']", "Dress");

            Reusable_Library.click(driver, "//*[@class='L_d7U']", "Clicking on the 1st Dress");

            Reusable_Library.click(driver, "//*[text()='" + size + "']", "Click on XXS");

            Thread.sleep(2000);

            Reusable_Library.click(driver, "//*[contains(@class,'_2veMA')]", "Add to the bag");

            Thread.sleep(3000);


            Reusable_Library.mouseHover(driver, "(//*[contains(@class,'modalContainer__8Q61X')]) [3]", "hover");

            Reusable_Library.click(driver, "//a[text()='View Bag & Check Out']", "view Bag & Check out ");
            Thread.sleep(1000);

            Reusable_Library.dropdownByText(driver, "//*[@id='qdd-0-quantity']", quantity, "Dropdown List");
            Thread.sleep(1000);

            Reusable_Library.click(driver, "//*[@id='continue-to-checkout']", "Checkout");

            Reusable_Library.click(driver, "//*[text()='Continue as Guest']", "Continue as Guest");
            Thread.sleep(1000);

            //enter first name value
            Reusable_Library.userKeys(driver, "//*[@name='firstname']", firstName, "First Name");

            //enter last name value
            Reusable_Library.userKeys(driver, "//*[@name='lastname']", lastName, "Last Name");
            Thread.sleep(1000);

            //enter email address
            Reusable_Library.userKeys(driver, "//input[@name='email']", email, "Email Add");

            //confirm email address
            Reusable_Library.userKeys(driver, "//input[@name='confirmEmail']", email, "Confirm Email");


            //entering phone number
            Reusable_Library.userKeys(driver, "//*[@name='phone']", phoneNumber, "Phone Number");

            Reusable_Library.click(driver, "//*[text()='Continue']", "continue");

            Reusable_Library.userKeys(driver, "//*[@name='shipping.line1']", streetAdd, "Street Address");

            Reusable_Library.userKeys(driver, "//*[@name='shipping.postalCode']", postalCode, "PostalCode");

            Reusable_Library.userKeys(driver, "//*[@name='shipping.city']", City, "City");

            Reusable_Library.dropdownByText(driver, "//*[@name='shipping.state']", State, "State");

            Reusable_Library.click(driver, "//*[text()='Continue']", "click on continue");
            Thread.sleep(2000);

            Reusable_Library.click(driver, "//*[text()='Continue']", "click on continue");
            Thread.sleep(1000);

            Reusable_Library.userKeys(driver, "//*[@id='creditCardNumberInput']", CreditCardNumber, "Credit Number");

            Reusable_Library.dropdownByText(driver, "//*[@name='expMonth']", expirtationMonth, "Months");

            Reusable_Library.dropdownByText(driver, "//*[@name='expYear']", ExYear, "Year");

            Reusable_Library.userKeys(driver, "//*[@name='cvv']", cvvCode, "code");


            Reusable_Library.click(driver, "//*[text()='Place Order']", "place the order");
            Thread.sleep(2000);

            String Result = Reusable_Library.captureText(driver, "//*[@class='xnY7x notification']", "gettext");

            System.out.println("My Error Message is " + Result);

            Label label = new Label(14, i, Result);

            writableSheet.addCell(label);


            driver.manage().deleteAllCookies();

        }// end of loop

        //outside of loop we need to write and close the excel
        writableFile.write();
        writableFile.close();
        readableFile.close();












    } // end of main method
} // end of java class
