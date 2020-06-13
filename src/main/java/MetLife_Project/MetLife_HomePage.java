package MetLife_Project;

import Reusable_Class.Abstract_Class;
import Reusable_Class.Reusable_Library;
import Reusable_Class.Reusable_Library_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_HomePage extends Abstract_Class {
     ExtentTest logger ;

     public MetLife_HomePage(WebDriver driver){
          super();
          PageFactory.initElements(driver,this);
          this.logger = super.logger;

     } // end of constructor

     public MetLife_HomePage solutions(){
          Reusable_Library_Logger.click(driver,"//div[contains(@class,'item-title font-eyebrow-1')]","clicking on solution",logger);
return new MetLife_HomePage(driver);
     }


     public MetLife_HomePage takeAlongDental(){
          Reusable_Library_Logger.click(driver,"//*[contains(@href,'takealongdental')]","takeaLongDental",logger);
          return new MetLife_HomePage(driver);

     } // end of takealongdental




}
