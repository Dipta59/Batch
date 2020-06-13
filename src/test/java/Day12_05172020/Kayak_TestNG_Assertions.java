package Day12_05172020;

import Reusable_Class.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Kayak_TestNG_Assertions {


    // declare the webdriver outside of all method to be reusable
    WebDriver driver;
    @BeforeSuite
    public void defineDiver(){
       driver = Reusable_Library.setDriver();
    } // end of before suite

    @Test
    public void KayakTestCase() throws InterruptedException {
        driver.navigate().to("https://www.kayak.com");
    Thread.sleep(2000);
    // verify the title using Hard assertion
       // Assert.assertEquals(driver.getTitle(),"search hotels, cars");
        //using soft assertion
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(driver.getTitle(),"Search Flights, Hotels & Rental Cars | KAYAK");
        //click airport or city

        Thread.sleep(5000);
        Reusable_Library.click(driver,"//*[text()='Enter an airport or city']","Search Filed");
        // enter the airport
        Reusable_Library.userKeys(driver, "//*[@name='pickup']","JFK","Search field");
        //pass assertAll that way it doesn't ski[ all your test steps
        sAssert.assertAll();
        


    } // end of test method


    @AfterSuite
    public void closeSession (){


    } // end of after suite


















} // end of java class
