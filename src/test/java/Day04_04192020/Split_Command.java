package Day04_04192020;

public class Split_Command {
    public static void main(String[] args) {

        // create a string message first and store it as a single string variable
        String message = "Welcome to Selenium Automation class ";
        // i want to only print the keyword 'Selenium' from my message variable
        // we need to define String array variable in order to split the message
        String [] arrayResult = message.split(" ");
        //print the result
        System.out.println ("My final message is " + arrayResult[2]);

        String dipta = "Welcome to the class";
        String [] wowD = dipta.split(" ");
        System.out.println("My final message is " +wowD[3] );









    } // end of main method
} // end of java class
