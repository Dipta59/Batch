package Day02_04122020;

public class Dynamic_Array {
    public static void main(String[] args) {

// declare string dynamic array variables
        String[] locations, countries;
        // declare integer dynamic array variables
        int[] number, houseAddress;
        // define the dynamic array with the length (size of that variable
        countries = new String [6];
        countries [0] = "USA";
        countries [1] = "Canada";
        countries [2] = "Russia";
        countries [3] = "Bangladesh";
        countries [4] = "India";
        countries [5] = "China";

        System.out.println(countries [1] + countries [4]);

        //define the int dynamic array
        number = new int [5];
        number [0] = 1;
        number [1] = 10;
        number [2] = 20;
        number [3] = 30;
        number [4] = 40;
        System.out.println(number [2] + number [4]);


    }// end of main method

}// end of java class
