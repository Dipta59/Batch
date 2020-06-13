package MetLife_Project;

import Reusable_Class.Abstract_Class;
import Reusable_Class.Reusable_Library;
import Reusable_Class.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Metlife_Zipcode extends Abstract_Class {
    ExtentTest logger;

    public Metlife_Zipcode(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    } // end of constructor

    public Metlife_Zipcode SearchBox(String uservalue){
        Reusable_Library_Logger.userKeys(driver,"//*[@id='txtZipCode']",uservalue,"zipcode",logger);
        return new Metlife_Zipcode(driver);


    } // end of zipcode

    public  Metlife_Zipcode clickgo (){
        Reusable_Library_Logger.click(driver,"//*[@id='txtZipCodetxt']","clickOnGO",logger);
        return new Metlife_Zipcode(driver);
    } // end of clickGO
    




}
