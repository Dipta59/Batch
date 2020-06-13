package Day16_06072020;

import Reusable_Class.Abstract_Class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Yahoo_Page_Object_Search_Result extends Abstract_Class {

    // using arrayList to define array test date


@Test
    public void Yahoo_Search_Result() throws InterruptedException {
    // using arrayList to define array test date
    ArrayList<String> cars = new ArrayList<>();
    cars.add("Lexus");
    cars.add("BMW");
    cars.add("Honda");

    for(int i = 0; i<cars.size(); i++) {

        logger.log(LogStatus.INFO, "navigating to yahoo home page");

        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);
        Yahoo_Base_Class.yahoo_homepage().searchField(cars.get(i));
        //click on search icon
        Yahoo_Base_Class.yahoo_homepage().searchIcon();
        Thread.sleep(2500);
        //scroll to the bottom of the page
        Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
        //getting search number
        Yahoo_Base_Class.yahoo_search_result_page().searchNumber();
    } // end of for loop

} // end of Test








} // end of java class
