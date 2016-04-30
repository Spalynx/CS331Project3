import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Last Modified by Brandon Hathaway on 4/7/2016.
 */

/**
 * This is the main class that runs the program and allows the user to enter their name
 * and the score they achieved after playing a game.
 */
public class Main {
    public static void main(String[] args){

        // Instance variables
        int choice;
        int player_score;
        String player_name;
        String[] high_score_player_names = new String[6];
        int[] high_score_player_values = new int[6];

        Scanner input = new Scanner(System.in);
        High_Score player = new High_Score();

        try{
            // Creates a file that will contain the high scores and players names.
            PrintWriter output = new PrintWriter(new FileOutputStream("High Scores.txt"));
            do{
                // Allows the user to enter in names and scores for the game they just played.
                System.out.println("Enter in your name.");
                player_name = input.nextLine();
                System.out.println("Enter in your score that you reached in the game.");
                player_score = input.nextInt();
                input.nextLine();

                player.playerScore(player_name,player_score);
                System.out.println("Display high scores: 1 = (yes), 0 = (no)");
                choice = input.nextInt();
                input.nextLine();

                // Displays the high scores from the players in a text file.
                if(choice == 1){
                    high_score_player_names = player.getTopNames();
                    high_score_player_values = player.getTopScores();
                    for(int k = 0; k < high_score_player_names.length -1; ++k){
                        //System.out.println("Rank " + (k+1) + ": " + high_score_player_names[k] + " - " + high_score_player_values[k]);
                        output.println("Rank " + (k+1) + ": " + high_score_player_names[k] + " - " + high_score_player_values[k]);
                    }
                }

                // Asks if the user would like to enter in another player and score.
                System.out.println("Play again: 1 = (yes) 0 = (no)");
                choice = input.nextInt();
                input.nextLine();
            } while(choice != 0);
            output.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
