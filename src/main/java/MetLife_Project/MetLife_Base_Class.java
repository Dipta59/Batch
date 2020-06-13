package MetLife_Project;

import Reusable_Class.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Base_Class extends Abstract_Class {

    public MetLife_Base_Class(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);

    } // end of constructor

    public static MetLife_HomePage metLife_homePage(){
        MetLife_HomePage metLife_homePage = new MetLife_HomePage(driver);
        return metLife_homePage;
    } // end of object metlife homepage

    public static Metlife_Enroll metlife_enroll(){
        Metlife_Enroll metlife_enroll = new Metlife_Enroll(driver);
        return metlife_enroll;
    } // end of object metlife_enroll

    public static Metlife_Zipcode metlife_zipcode(){
        Metlife_Zipcode metlife_zipcode = new Metlife_Zipcode(driver);
        return metlife_zipcode;
    } // end of object metlife zipcode

    public static MetLife_Dental_Program metLife_dental_program(){
        MetLife_Dental_Program metLife_dental_program = new MetLife_Dental_Program(driver);
        return metLife_dental_program;
    } // end of object metlife dental program

    public static Metlife_PPO metlife_ppo(){
        Metlife_PPO metlife_ppo = new Metlife_PPO(driver);
        return metlife_ppo;
    } // end of object metlife ppo



}
