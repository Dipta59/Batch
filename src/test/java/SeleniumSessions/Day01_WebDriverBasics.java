package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_WebDriverBasics {
    public static void main(String[] args) {

        // 1. firefox browser:
        //    geckodriver.

        //System.setProperty("webdriver.gecko.driver","src//Resource//geckodriver.exe");
        //WebDriver driver = new FirefoxDriver(); // launch firefox

        //driver.navigate().to("https://google.com");

        //2. Chrome browser
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // launch chrome

        driver.navigate().to("https://google.com");   // entry url

        String title = driver.getTitle(); // get title
        System.out.println(title);
        //validation point :
        if(title.equals("Google")){
            System.out.println("correct title");
        }else{
            System.out.println("in-correct title");
        }

        System.out.println(driver.getCurrentUrl());   // it will get the current url in the website

        System.out.println(driver.getPageSource());   // you get the page source where the code is written


        driver.quit();




        

    } // end of main method
} // end of java class
