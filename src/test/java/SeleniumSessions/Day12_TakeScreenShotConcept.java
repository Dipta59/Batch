package SeleniumSessions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class Day12_TakeScreenShotConcept {
    public static void main(String[] args) throws IOException {
    System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver83.exe");
    ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

    WebDriver driver = new ChromeDriver(options);

    driver.navigate().to("https://www.google.com");

        // ScreenShot .. All we need to remember is getScreenshotAS

        String fileName = ".png";
        String directory = "src//main//java//HTML_Report//Screenshot//";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        //String imgPath = directory + fileName;




} // end of main method
} // end of java class
