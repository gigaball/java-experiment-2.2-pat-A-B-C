import java.util.ArrayList;
import java.util.Scanner;

public class SumOfIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers (type 'done' to finish):");

        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {

                int value = Integer.parseInt(input);

                numbers.add(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer or 'done'.");
            }
        }

        int sum = 0;
 
        for (Integer num : numbers) {
            sum += num; 
        }

        System.out.println("The sum of entered integers is: " + sum);
        sc.close();
    }
}
