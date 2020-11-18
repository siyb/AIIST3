import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        loop:
        for (; ; ) {
            System.out.println("Enter command!");
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];

            int parameter1 = 0;
            int parameter2 = 0;

            if (tokens.length == 3) {
                parameter1 = Integer.parseInt(tokens[1]);
                parameter2 = Integer.parseInt(tokens[2]);
            }

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
                    if (parameter2 == 0) {
                        System.err.println("Cannot divide by 0!");
                        break;
                    }
                    System.out.printf("> %d\n", parameter1 / parameter2);
                    break;
                case "end":
                    break loop;
                default:
                    System.err.println("Illegal Command!");
                    break;
            }
        }
        scanner.close();
    }
}
