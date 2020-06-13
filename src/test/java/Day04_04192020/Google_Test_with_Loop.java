package Day04_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Test_with_Loop {
    public static void main(String[] args) throws InterruptedException {

// set the system chrome driver path at least once in one of your main method
        //webdriver.chrome.driver needs to be in lower case string followed by your driver path
        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");
        // you declare and define the driver
        WebDriver driver = new ChromeDriver();
        // create a dynamic array for city to loop through certain values from the array
        String []city = new String[4];
        city[0] = "Brooklyn";
        city[1] ="Queens";
        city[2] = "Bronx";
        city[3] = "Staten Island";
        // this is where you will start your loop from navigate up until before quit

        for(int i=0;i<city.length; i++) {
            // opening the browser automatically to go to google home page
            driver.navigate().to("https://www.google.com");
            // wait few seconds after navigating to page so browser can load properly
            //sleep statement handles in miliseconds so example 1 sec = 1000 miliseconds
            Thread.sleep(2000);
            driver.manage().window().maximize();

            // locate the search field by inspecting it first and then enter a keyword lets say cars
            driver.findElement(By.name("q")).sendKeys(city[i]);
            //click on google search ( you can also write submit)
            driver.findElement(By.name("btnK")).submit();
            // to capture a text from web site you need to
            Thread.sleep(2000);
            String message = driver.findElement(By.id("result-stats")).getText();
            // using array variable to split above message
            String[] arrayResult = message.split(" ");
            System.out.println("My city is  " + city[i] + " and search number is " + arrayResult[1]);
        }
        //Thread.sleep(2000);
        // maximize your browser


        // close vs quit the session
        //quit will kill the driver from your task memory
        //close will only close the driver but not from your memory
        // i prefer to use quit
        driver.quit();
    }
}