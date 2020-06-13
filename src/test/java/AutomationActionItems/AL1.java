package AutomationActionItems;

public class AL1 {
    public static void main(String[] args) {

        // Dipta Das                                 Automation Action Item # 1

        String[] zipcode = new String[4];
        zipcode[0] = "11218";
        zipcode[1] = "11222";
        zipcode[2] = "11233";
        zipcode[3] = "12345";

        int[] streetNumber = new int[4];
        streetNumber[0] = 4575;
        streetNumber[1] = 666;
        streetNumber[2] = 87;
        streetNumber[3] = 911;


        int i = 0;
        while (i < streetNumber.length){
            System.out.println("my zip code is " + zipcode [i] + " my street name is " + streetNumber[i]);
            i = i + 1;
        }// end of while loop
        for(int d = 0; d <streetNumber.length; d++){
            System.out.println("my street number is " + streetNumber[d] + " my zip code is " + zipcode[d]);
        }// end of for loop



        } // end of main method

}// end of java class
