package SeleniumSessions;

import Reusable_Class.Reusable_Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Day05_HandleFileUploadPopUp {
    public static void main (String[] args) throws InterruptedException {

        WebDriver driver = Reusable_Library.setDriver();

        driver.navigate().to("https://html.com/input-type-file/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("C:\\Users\\dipta\\OneDrive\\Desktop/quiz.png");


















    } // end of main method
} // end of java class
