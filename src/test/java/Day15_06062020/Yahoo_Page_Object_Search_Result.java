package Day15_06062020;

import Reusable_Class.Abstract_Class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Yahoo_Page_Object_Search_Result extends Abstract_Class {

@Test
    public void Yahoo_Search_Result() throws InterruptedException {
    logger.log(LogStatus.INFO,"navigating to yahoo home page");
    driver.navigate().to("https://www.yahoo.com");
    Thread.sleep(2000);
    Yahoo_Base_Class.yahoo_homepage().searchField("cars");
    //click on search icon
    Yahoo_Base_Class.yahoo_homepage().searchIcon();
    Thread.sleep(2500);
    //scroll to the bottom of the page
    Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
    //getting search number
    Yahoo_Base_Class.yahoo_search_result_page().searchNumber();


} // end of Test








}
