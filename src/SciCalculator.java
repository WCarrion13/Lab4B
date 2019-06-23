import java.util.Scanner; //New comment for Lab4B

public class SciCalculator {
    public static void main(String args[]) {    //Main method; returns no values

        int selection;      //Initialization of variables
        double x = 0;
        double y = 0;
        String z;
        double totalSum = 0;
        int totalCalcs = 0;
        double average;
        double result = 0;
        double resultOld;
        boolean nextOp;
        Scanner scnr = new Scanner(System.in);

        while (true) {
            System.out.println("Current Result: " + result);      //Display current result and table of choices
            System.out.println("\nCalculator Menu\n---------------");
            System.out.println("0. Exit Program\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exponentiation\n6. Logarithm\n7. Display Average\n");
            nextOp = false;

            while (!nextOp) {
                System.out.println("Enter Menu Selection: ");       //Prompt user for input
                selection = scnr.nextInt();
                resultOld = result;
                totalSum = totalSum + result;
                result = 0;

                if (selection >= 1 && selection <=6) {      //Calculation performed if this loop is entered
                    System.out.println("Enter first operand: ");
                    z = scnr.next();
                    x = (z.equals("RESULT")) ? resultOld : Double.parseDouble(z);

                    System.out.println("Enter second operand: ");
                    z = scnr.next();
                    y = (z.equals("RESULT")) ? resultOld : Double.parseDouble(z);

                    totalCalcs = totalCalcs + 1;
                    nextOp = true;
                }

                switch (selection) {
                    case 0:     //Exit program
                        System.out.println("Thanks for using this calculator. Goodbye!");
                        return;
                    case 1:     //Addition
                        result = x + y;
                        break;
                    case 2:     //Subtraction
                        result = x - y;
                        break;
                    case 3:     //Multiplication
                        result = x * y;
                        break;
                    case 4:     //Division
                        result = x / y;
                        break;
                    case 5:     //Exponentiation (first ^ second)
                        result = Math.pow(x, y);
                        break;
                    case 6:     //Logarithm (base (first) of second)
                        result = Math.log(y)/Math.log(x);
                        break;
                    case 7:     //Average of calculations
                        if (totalCalcs == 0) {
                            System.out.println("Error: No calculations yet to average!\n");
                        } else {
                            average = totalSum/totalCalcs;
                            System.out.println("Sum of calculations: " + RoundTo2(totalSum) + "\nNumber of calculations: " + totalCalcs + "\nAverage of calculations: " + RoundTo2(average));
                        }
                        break;
                    default:
                        System.out.println("Error: Invalid selection!\n");
                }
            }
        }
    }

    static double RoundTo2(double numToRound) {     //Custom method for rounding a given # to 2 decimal places
        numToRound = Math.round(numToRound*100)/100.0;
        return numToRound;
    }
}

