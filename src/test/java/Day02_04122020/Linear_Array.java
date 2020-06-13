package Day02_04122020;

public class Linear_Array {
    public static void main(String[] args) {
        // declare the array variables first

        String[] locations , countries, places;

        // declare the empty int array variables first
        int [] number, houseAddress;
 // define the varriables
 locations = new String [] {"Sixflag","Disney","beach"};
 countries = new String [] {"Bangladesh","USA","Canada","India"};

 //define the int array varriables
        number = new int [] {1,2,3,4};
        houseAddress = new int [] {222,333,444,555};

        // print the last value from locations variable
        System.out.println("my location is " + locations [2] + " the place to go " + countries [0] ) ;

        System.out.println(number [3] + houseAddress [0]);
System.out.println(number[0] + number[2]);
        System.out.println(houseAddress[3] + number [2]);


    } // end of main method

} // end of java class
