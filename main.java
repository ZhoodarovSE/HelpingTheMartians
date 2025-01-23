
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Find three boxes with valuable cargo that are buried along a 7-kilometer route.");
        for(int attempt=1;attempt<=5;attempt++){
            System.out.println("Attempt " + attempt + ": Enter three kilometers (1 to 7) where you think the boxes might be buried.");
            int[] userInput=new int[3];
            for(int i=0;i<3;i++){
                userInput[i]=sc.nextInt();
            }
        }
    }
}
