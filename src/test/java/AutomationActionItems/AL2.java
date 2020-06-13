package AutomationActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AL2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver83.exe");

        // declare and define the driver
        WebDriver driver = new ChromeDriver();

        String[] state = new String[5];
        state[0] = "New York";
        state[1] = " New Jersey";
        state[2] = "Florida";
        state[3] = "Taxes";
        state[4] = "Ohio";

        for (int i = 0; i < state.length; i++) {

            //open the browser automatically to go to bing home page
            driver.navigate().to("https:Bing.com");


            //sleep statement is make you wait couple of seconds
            Thread.sleep(2000);

            // to maximize the browser
            driver.manage().window().maximize();
            // writing in the search bar
            driver.findElement(By.name("q")).sendKeys(state[i]);
            // pressing enter !
            driver.findElement(By.name("search")).submit();
            // to get the results !
            String message = driver.findElement(By.id("b_tween")).getText();
            // keeping a space in between
            String[] arrayResult = message.split(" ");
            // printing out the entire line !
            System.out.println(" my states are " + state[i] + " and the results " + arrayResult[0]);

            // sleep statement is to make you wait couple of seconds
            Thread.sleep(2000);


        }// end of for loop

        //quitting the browser !
        driver.quit();

    } // end of main method
}// end of java class
