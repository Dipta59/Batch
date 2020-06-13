package Day11_05162020;

import Reusable_Class.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class GoogleSearch_TestNG_Suites {
    // when using annotation method your local driver
    //must be declared outside so i can call it
    // on all my annotation method
    WebDriver driver;
    @BeforeSuite
    public void callDriver() throws InterruptedException {
        driver = Reusable_Library.setDriver();
        driver.navigate().to("https://google.com");
        Thread.sleep(2000);
    } // end of beforeMethod

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    } // end of aftermethod



    @Test(priority = 1)
    public void googleSearch() throws InterruptedException {
        // end keyword car on my search field
        Reusable_Library.userKeys(driver, "//*[@name='q']", "cars", "Search field");
        // click on submit
        Reusable_Library.submit(driver, "//*[@name='btnK']", "Google Search Button");
        Thread.sleep(2000);
    }// end of test priority


        @Test(priority = 2)
        public void captureTheResult(){
        // capture text and print out the search number
        String searchResult = Reusable_Library.captureText(driver,"//*[@id='result-stats']", "search Results");
        // split the text and print the number
        String[] arraySearch = searchResult.split( " ");
        System.out.println("My search number for car is " + arraySearch[1]);
    } // end of google test

    //Test(dependsOnMethods)
    // when you use dependsOnMethods in your @test that means your second test is dependant
    // on your first test if first test fails second test will be skipped
    // if all test has priorities they might or might nor be dependant on each other










} // end of java class
