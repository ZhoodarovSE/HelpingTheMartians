
import java.util.Scanner;
import java.util.Random;
public class main{
    public static void main(String[] args) {
        int[] cargoLocation = {0, 0, 1, 2,0, 3, 0};

        Scanner sc = new Scanner(System.in);
        System.out.println("Find three boxes with valuable cargo that are buried along a 7-kilometer route.");

            System.out.println("Enter the guessing numbers:");
            int[] martiansInput = new int[3];
            for (int i = 0; i < 3; i++) {
                martiansInput[i] = sc.nextInt();
            }
            int count = correctGuessCount(cargoLocation, martiansInput);
            System.out.println("The number of correct guesses: \n" + count);
            int attempts = 1;
            while (count < 3) {
                System.out.println("Enter the guessing numbers:");
                for (int i = 0; i < 3; i++) {
                    martiansInput[i] = sc.nextInt();
                }
                count = correctGuessCount(cargoLocation, martiansInput);
                System.out.println("The number of correct guesses: \n" + count);
                attempts++;
                if (attempts == 5) {
                    attempts = 0;
                    cargoLocation = newCargoLocation(cargoLocation);
                    System.out.println("The cargo locations shuffled.");
                }
            }

            System.out.println("The locations of the cargo:");
            for (int i = 0; i < 3; i++) {
                System.out.print(martiansInput[i] + " ");
            }

    }

        public static int[] newCargoLocation(int[] array) {
            int[] shuffledArray = array.clone();
            Random random = new Random();

            for (int i = shuffledArray.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                int temp = shuffledArray[i];
                shuffledArray[i] = shuffledArray[j];
                shuffledArray[j] = temp;
            }

            return shuffledArray;
        }
    public static int correctGuessCount(int[] cargoLocation, int[] martiansInput) {
        int[] cargoLocation1 = new int[7];
        System.arraycopy(cargoLocation, 0, cargoLocation1, 0, 7);
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (cargoLocation1[martiansInput[i] - 1] > 0) {
                count++;
                cargoLocation1[martiansInput[i] - 1] = 0;
            }
        }
        return count;
    }
    }

