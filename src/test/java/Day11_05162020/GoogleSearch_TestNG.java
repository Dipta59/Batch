package Day11_05162020;

import Reusable_Class.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GoogleSearch_TestNG {
    // when using annotation method your local driver
    //must be declared outside so i can call it
    // on all my annotation method
    WebDriver driver;
    ArrayList<String> cars = new ArrayList();
    @BeforeMethod
    public void callDriver() throws InterruptedException {
        driver = Reusable_Library.setDriver();
        cars.add("BMW");
        cars.add("Lexus");

    } // end of beforeMethod

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    } // end of aftermethod


    @Test
    public void googleSearch() throws InterruptedException {
        for (int i = 0; i < cars.size(); i++) {
            driver.navigate().to("https://google.com");
            // end keyword car on my search field
            Reusable_Library.userKeys(driver, "//*[@name='q']", cars.get(i), "Search field");
            // click on submit
            Reusable_Library.submit(driver, "//*[@name='btnK']", "Google Search Button");
            Thread.sleep(2000);
            // capture text and print out the search number
            String searchResult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "search Results");
            // split the text and print the number
            String[] arraySearch = searchResult.split(" ");
            Reporter.log("My search number for car is " + arraySearch[1]);
            System.out.println("My search number for car is " + arraySearch[1]);
        } // end of for loop

    }// end of google test









} // end of java class
