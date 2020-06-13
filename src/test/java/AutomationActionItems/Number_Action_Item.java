package AutomationActionItems;

import Reusable_Class.Abstract_Class;
import org.testng.annotations.Test;

public class Number_Action_Item extends Abstract_Class {
    @Test
            public void numberAction(){


        System.out.println("Divided by 5:");
        for (int i=1; i<100; i++){
            if (i%5==0)
            System.out.println(i +" ");
         } // end of for loop

        String [] list = new String [5];

        list [0] = "a";
        list [1] = "b";
        list [2] = "c";
        list [3] = "d";
        list [4] = "e";
        for (int i =0; i<list.length; i++) {

            if (list[0]=="a" || list [4] == "e"){
                System.out.println("vowel" );
            } else {
                System.out.println("Non-Vowel");
            } // end of if and else



        } // end of for loop





    } // end of test

} // end of java class
