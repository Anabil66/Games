package rps;

import java.util.Random;

public class RpsLogic {
    private static String[] options = { "rock", "paper", "scissors" };

    double[] rock = { 1, 0 }; // any vector would do but we take unit vector along x-axis for convention
    double[] paper = Rotation.rotation(rock, 120);
    double[] scissors = Rotation.rotation(paper, 120);

    double[][] vector_options = { rock, paper, scissors };

    protected int map(String option) {
        if (option.equals(options[0])) {
            return 0;
        }
        if (option.equals(options[1])) {
            return 1;
        }
        if (option.equals(options[2])) {
            return 2;
        }
        return -1;
    }

    static Random randObj = new Random();
    static int computer_choice;

    public void result(String choice) {
        choice = choice.toLowerCase();
        if (!(choice.equals(options[0])) && !(choice.equals(options[1])) && !(choice.equals(options[2]))) {
            System.out.println("Improper choice");
            return;
        }
        int user_choice = map(choice);

        computer_choice = randObj.nextInt(3);

        System.out.println("Computer choice: " + options[computer_choice]);

        if (Rotation.compare(vector_options[user_choice], vector_options[computer_choice]) == 1) {
            System.out.println("You Lose!");
        } else if (Rotation.compare(vector_options[user_choice], vector_options[computer_choice]) == -1) {
            System.out.println("You Win!");
        } else {
            System.out.println("Its a Draw!");
        }
    }

}
