package AutomationActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Al3_Liberty_Mutual {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src//Resource//chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized","incognito");

        WebDriver driver = new ChromeDriver(options);


        String [] zipcode = new String [4];
        zipcode[0] = "11218";
        zipcode [1] = "11210";
        zipcode [2] = "11219";
        zipcode [3] = "11215";
        for( int i = 0; i<zipcode.length; i++){

        driver.navigate().to("https://www.libertymutual.com");

        Thread.sleep(3000);

        String Title = driver.getTitle();
        if(Title.equals ("Liberty Mutual")) {
            System.out.println("Correct title");
        } else{
            System.out.println("Wrong Title " + Title);
        } // end of if else



        // finding the agent
        driver.findElement(By.xpath("//*[@class='field']")).click();

        // writing the zipcode
        driver.findElement(By.xpath("//*[@name='location']")).sendKeys(zipcode[i]);
        // clicking on search
        driver.findElement(By.xpath("//button[contains(@class,'Button--secondary')]")).click();

        Thread.sleep(3000);

        if(i == 0) {
            driver.findElements(By.xpath("//a[contains(@href,'meet-our-agents')]")).get(0).click();
            ////*[text()='Show agents in this office']    <------------ creating the xpath using xpath
        }
        Thread.sleep(2000);
        if( i == 1) {
            driver.findElements(By.xpath("//a[contains(@href,'meet-our-agents')]")).get(2).click();
        }

        if ( i == 2){
            driver.findElements(By.xpath("//a[contains(@href,'meet-our-agents')]")).get(3).click();
        }
         if (i == 3) {
             driver.findElements(By.xpath("//a[contains(@href,'meet-our-agents')]")).get(1).click();
         }
         Thread.sleep(4000);

         String message = driver.findElement(By.xpath("//*[@class='jsx-188877792 office']")).getText();
         System.out.println("Address of the office including phone number and hours of operation are " + message );




        } // end of for loop


    } // end of main method

} // end of java class
