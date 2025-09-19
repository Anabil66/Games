package rps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user_choice;
        RpsLogic rps = new RpsLogic();
        
        String play = "y";

        while(play.equals("y")){
            System.out.println("Enter your choice");
            user_choice = scanner.nextLine();

            rps.result(user_choice);

            System.out.println("Continue Playing?(y/n)");
            play = scanner.nextLine().toLowerCase();
        }

        scanner.close();

    }
}
