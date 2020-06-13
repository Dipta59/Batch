package MetLife_Project;

import Reusable_Class.Abstract_Class;
import Reusable_Class.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Metlife_Enroll extends Abstract_Class {

    ExtentTest logger;

    public Metlife_Enroll(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    } // end of constructor

    public MetLife_HomePage enroll (){
        Reusable_Library_Logger.click(driver,"//a[contains(@class,'2nd table')]","Enroll now",logger);
        return new MetLife_HomePage(driver);
    } // end of enroll now



}
