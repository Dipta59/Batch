package Day13_05302020;

import Reusable_Class.Reusable_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class List_Boolean {

    WebDriver driver;


    @BeforeSuite
    public void defineDriver(){
        driver = Reusable_Library.setDriver();

    } // end of before method


    @Test
    public void yahoo_verification() throws InterruptedException {
        driver.navigate().to("https://www.yahoo.com");
        // 3 or 4 seconds for page to load
        Thread.sleep(3500);
        // i want to count all the links in yahoo homepage and print it
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px) Mstart(11px)')]"));
        System.out.println(linkCount.size());

        if(linkCount.size()== 12){
            System.out.println("My yahoo home page link count macthes and it is " + linkCount.size());
        } else {
            System.out.println("My yahoo home page link count doesn't matches and actual is " + linkCount.size());
        } // end of if else

        Reusable_Library.click(driver,"//*[@id='header-signin-link']","sign In");

        //wait few seconds

        Thread.sleep(3000);
        //verify the state of the checkbox for stay signed in section
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxState == true){
            System.out.println("checkbox is selected by default");
        } // end of if else




    } // end of test


    @AfterSuite
    public void quitDriver(){
        //driver.quit();


    }








} // end of java class
