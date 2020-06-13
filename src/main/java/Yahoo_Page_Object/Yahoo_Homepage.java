package Yahoo_Page_Object;

import Reusable_Class.Abstract_Class;
import Reusable_Class.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Homepage extends Abstract_Class {

    ExtentTest logger;
    // we need to create a constructor method that defines
    // driver and logger to be reused locally to this page class
    //constructor inherits same name as your java class

    public Yahoo_Homepage(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object concept
        this.logger = super.logger;


    } // end of constructor

    // method for searchfield
    public Yahoo_Homepage searchField(String userValue){
        Reusable_Library_Logger.userKeys(driver,"//*[@id='header-search-input']",userValue,"Search field",logger);
        return new Yahoo_Homepage(driver);
        // the driver that i used is returning you the same
        // Yahoo Homepage
    }  // end of search field

    // method for searh icon
    public Yahoo_Homepage searchIcon(){
        Reusable_Library_Logger.click(driver,"//*[@id='header-desktop-search-button']","Search field",logger);
        return new Yahoo_Homepage(driver);

    }  // end of search icon method












}
