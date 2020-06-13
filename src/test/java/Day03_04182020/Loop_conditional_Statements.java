package Day03_04182020;

public class Loop_conditional_Statements {
    public static void main(String[] args) {
        String[] city = new String[4];
        city[0] = "Brooklyn";
        city[1] = "Queens";
        city[2] = "Manhattan";
        city[3] = "Bronx";

        for (int i = 0; i < city.length; i++) {
            //using if else if condition
            //string can have equal() command or == but integer must have ==
            // equal command when the expect value is matching the array value
            // equal IgnoreCase command will ignore case sensitivity as long as the value
            // spelling is correct

           if (city[i] == "Brooklyn") {
                System.out.println("my city is " + city[i]);
            } else if (city[i] == "Queens") {
                System.out.println("my city is " + city[i]);
            }
        }// end of if else if condition
        // different operators are &&, ||, >, <, <=, =>, ==
        // using or || operators to do the same conditions as above
        for(int i = 0; i <city.length; i++)
        if(city[i] =="Brooklyn" || city[i] == "Queens"){
            System.out.println("My city is " + city[i]);
        }




    }// end of main method
} // end of java class
