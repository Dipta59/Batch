package Day03_04182020;

public class If_Else_With_Operators {
    public static void main(String[] args) {
        // scenario is if student grade is 90 to 100 then it's A
        // if student grade is 80 to below 90 then it's B
        // if student grade is 70 to below 80 then it's C
        // If anything below C is failure (F)

        // define a variable which will represent grade number
        int grade = 60;
        //&& represents and operator in java
        //&& and operator all condition has to be true
        // || ot operator one of the condition has to be true
        if( grade >= 90 && grade <= 100) {
            System.out.println("Students grade is A");
        } else if (grade >= 80 && grade <90){
            System.out.println("Students grade is B");
        } else if (grade>= 70 && grade < 80){
            System.out.println("students grade is C");
        }else {
            System.out.println("students grade is F");

        }// end of conditional statements




    }//end of main method
}// end of java class
