import java.util.Random;
import java.util.Scanner;

public class binary_addition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("(p)lay or (q)uit: "); //printing text for input
            char userChoice = scanner.next().charAt(0); //getting first char
            userChoice = Character.toLowerCase(userChoice); //converting all to lowercase

            if (userChoice == 'q') {
                break;
            } else if (userChoice != 'p') {
                continue;
            }

            //getting random binary strings
            int randomInt1 = random.nextInt(8); int randomInt2 = random.nextInt(8);
            String bin1 = Integer.toBinaryString(randomInt1); String bin2 = Integer.toBinaryString(randomInt2);

            System.out.printf("What is %s + %s? \n: ", bin1, bin2);

            try {
                String userGuess = scanner.next();
                if (randomInt1 + randomInt2 == Integer.parseInt(userGuess, 2)) {
                    System.out.println("Correct!");
                } else {
                    int rightAnswer = randomInt1 + randomInt2; String rightString = Integer.toBinaryString(rightAnswer);
                    System.out.println("Incorrect. The correct answer was " + rightString);
                }
            } catch (Exception e) {
                System.out.println(e);
            }//catch
        }//while
        scanner.close(); //not needed
    }//main
}//class