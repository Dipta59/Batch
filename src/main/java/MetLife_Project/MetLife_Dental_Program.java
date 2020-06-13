package MetLife_Project;

import Reusable_Class.Abstract_Class;
import Reusable_Class.Reusable_Library_Logger;
import com.google.inject.spi.Message;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Dental_Program extends Abstract_Class {

    ExtentTest logger;
    public MetLife_Dental_Program (WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;
    } // end of constructor

    public MetLife_Dental_Program gettingDP (String uservalue){
        Reusable_Library_Logger.click(driver,"//*[@class='" + uservalue + "']","clicking on PPO",logger);
        return new MetLife_Dental_Program(driver);
    } // Clicking PPO

    public MetLife_Dental_Program clickingEnroll(){
        Reusable_Library_Logger.click(driver,"//*[text()='ENROLL IN PROGRAM NOW']","Enroll Now",logger);
        return new MetLife_Dental_Program(driver);
    } //clicking on Enroll now

    public MetLife_Dental_Program refCode(String uservalue){
        Reusable_Library_Logger.userKeys(driver,"//*[@class='form-control']",uservalue,"referralCode",logger);
        return new MetLife_Dental_Program(driver);
    } // end of referralcode

    public  MetLife_Dental_Program clickgo(){
        Reusable_Library_Logger.click(driver,"//*[@id='enrollgobtn']","clicking on GO",logger);
        return new MetLife_Dental_Program(driver);
    } //clicking on GO

    public String getText (){
       String result = Reusable_Library_Logger.captureText(driver,"//*[@id='lblRefCodeError']","Print Text",logger);
        return result ;
    } // end of capturetext


    public MetLife_Dental_Program clickgo2 (){
        Reusable_Library_Logger.click(driver,"//*[contains(@class,'primaryborder')]","Enroll now",logger);
        return new MetLife_Dental_Program(driver);
    } // clicking on enroll now









}
