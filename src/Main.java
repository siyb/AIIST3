import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize a scanner that we can use to read input
        // from stdin (Standard Input)
        Scanner scanner = new Scanner(System.in);

        // labling our loop, so that we can break the loop inside the switch using its label
        loop:
        for (; ; ) { // loop forever, we could have also used while(true) but for is more fitting for a forever loop
            System.out.println("Enter command!");
            // split the user input line at space and assign the results to an array
            String[] tokens = scanner.nextLine().split(" ");
            // the first element in the line is the command, index 0 is the first index of the array
            String command = tokens[0];

            // our parameters are both 0 from the start
            int parameter1 = 0;
            int parameter2 = 0;

            // if all parameters (command, operand1 and operand2) have been given
            if (tokens.length == 3) {
                parameter1 = Integer.parseInt(tokens[1]);
                parameter2 = Integer.parseInt(tokens[2]);
            }

            // we need to determine which command was provided by the user
            switch (command) {
                case "add":
                    System.out.printf("> %d\n", parameter1 + parameter2);
                    break;
                case "subtract":
                    System.out.printf("> %d\n", parameter1 - parameter2);
                    break;
                case "multiply":
                    System.out.printf("> %d\n", parameter1 * parameter2);
                    break;
                case "divide":
                    // special case: we need to prevent divisions by zero!
                    if (parameter2 == 0) {
                        System.err.println("Cannot divide by 0!");
                        break;
                    }
                    System.out.printf("> %d\n", parameter1 / parameter2);
                    break;
                case "end":
                    // break to the loop label
                    break loop;
                default: // we do not accept any other commands
                    System.err.println("Illegal Command!");
                    break;
            }
        }
        // when the "end" command was issued by the user, the loop terminates and the program continues here!
        scanner.close();
    }
}
