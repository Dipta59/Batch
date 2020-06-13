package AutomationActionItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AL3_Practice {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src//Resource//chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized", "incognito");

        WebDriver driver = new ChromeDriver(options);
        String[] price = new String[3];
        price[0] = "50000";
        price[1] = "600000";
        price[2] = "7000000";

        String[] pay = new String [3];
        pay [0] = "40";
        pay [1] = "50";
        pay [2] = "60";

        String[] rate = new String[3];
        rate [0]= "10";
        rate [1] = "20";
        rate [2] = "30";


        String[] insurance = new String[3];
        insurance [0] ="2000";
        insurance [1] = "3000";
        insurance [2] ="4000";

        String[] month = new String[3];
        month [0] = "May";
        month [1] = "Jun";
        month [2] = "Jul";



        String[] year = new String[3];
        year[0] ="2005";
        year [1] ="2015";
        year [2] ="2035";

       int i = 0;
       while(i<=price.length){



            driver.navigate().to("https://www.mlcalc.com");

            Thread.sleep(3000);

            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Mortgage Calculator & Loan Calculator")) {
                System.out.println("Title matches with expected");
            } else {
                System.out.println("Title doesn't match " + actualTitle);
            } // end of if and else condition


//---------------------------------------------------------------------------------------------------------------------------------------------


            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            pPrice.clear();
            pPrice.sendKeys(price[i]);

            Thread.sleep(1000);

            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            dPayment.clear();
            dPayment.sendKeys(pay[i]);


            Thread.sleep(1000);


            WebElement intRate = driver.findElement(By.xpath("//*[@name='ir']"));
            intRate.clear();
            intRate.sendKeys(rate[i]);

            Thread.sleep(1000);


            WebElement propInsurance = driver.findElement(By.xpath("//*[@name='pi']"));
            propInsurance.clear();
            propInsurance.sendKeys(insurance[i]);

            Thread.sleep(1000);


            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select startMonthList = new Select(startMonth);
           driver.findElement(By.xpath("//*[text()='" + month[i] + "']")).click();



               driver.findElement(By.xpath("//*[@name='sy']")).click();
               Thread.sleep(1000);
               driver.findElement(By.xpath("//*[text()='" + year[i] + "']")).click();




            driver.findElement(By.xpath("//*[@class='button-calculate action']")).click();

            Thread.sleep(4000);

            String message = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
            String payoff = driver.findElements(By.xpath("//*[@class='big']")).get(2).getText();
            System.out.println("Total monthly payment " + message + " and mortgage payoff date " + payoff);


           i = i + 1;


        } // end of while loop


        driver.quit();

    } // end of main method


}// end of java class
