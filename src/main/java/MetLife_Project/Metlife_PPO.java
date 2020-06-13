package MetLife_Project;

import Reusable_Class.Abstract_Class;
import Reusable_Class.Reusable_Library;
import Reusable_Class.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_PPO extends Abstract_Class {
    ExtentTest logger;
    public Metlife_PPO (WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    } // end of constructor

    public String searchPage(){
       String result = Reusable_Library_Logger.captureText(driver,"//*[@class='col-sm-8']","PPO",logger);
        return result;
    } // end of searchPage



}
