package com.Spal;

/** Write a class that keeps track of the top five high scores that could be used for a video game. Internally, the
 * class should store the top scores in a data structure of your choice (the most straightforward way is to use arrays).
 * Each entry consists of a name and a score. The data stored in memory should be synchronized with a text file for
 * persistent storage.
 *  The constructor should test if the file exists. If it does not exist, then the file should be created with blank
 *  names for each of the players and a score of 0. If the file does exist, then the data from the file should be read
 *  into the class's instance variables.
 *  Along with appropriate constructors, accessors, and mutators, add the following methods:
 *      void playerScore (String name, int score):
 *          Whenever a game is over, this method is called with the player's name and final score. If the name is one of
 *          the top five, then it should be added to the list and the lowest score should be ropped out. If the score is
 *          not in the top five, then nothing happens.
 *      String[] getTopNames():
 *          Returns an array of the names of the top players, with the top player first, the second best player second, etc.
 *      int[] getTopScores():
 *          Returns an array of the scores of the top players, with the highest score first, the second highest score second, etc.
 *  @author Brandon Hathaway
 *  @since 4.30.16
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class C10_Question7{
    /**
     * This is the main class that runs the program and allows the user to enter their name
     * and the score they achieved after playing a game.
     * @author Brandon Hathaway
     */
    public static void testClasses() {
        // Instance variables
        int choice;
        int player_score;
        String player_name;
        String[] high_score_player_names = new String[6];
        int[] high_score_player_values = new int[6];

        Scanner input = new Scanner(System.in);
        High_Score player = new High_Score();

        try {
            // Creates a file that will contain the high scores and players names.
            PrintWriter output = new PrintWriter(new FileOutputStream("High Scores.txt", true));
            do {
                // Allows the user to enter in names and scores for the game they just played.
                System.out.println("Enter in your name.");
                player_name = input.nextLine();
                System.out.println("Enter in your score that you reached in the game.");
                player_score = input.nextInt();
                input.nextLine();

                player.playerScore(player_name, player_score);
                System.out.println("Display high scores: 1 = (yes), 0 = (no)");
                choice = input.nextInt();
                input.nextLine();

                // Displays the high scores from the players in a text file.
                if (choice == 1) {
                    high_score_player_names = player.getTopNames();
                    high_score_player_values = player.getTopScores();
                    for (int k = 0; k < high_score_player_names.length - 1; ++k) {
                        //System.out.println("Rank " + (k+1) + ": " + high_score_player_names[k] + " - " + high_score_player_values[k]);
                        output.println("Rank " + (k + 1) + ": " + high_score_player_names[k] + " - " + high_score_player_values[k]);
                    }
                }

                // Asks if the user would like to enter in another player and score.
                System.out.println("Play again: 1 = (yes) 0 = (no)");
                choice = input.nextInt();
                input.nextLine();
            } while (choice != 0);
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/**
 * This class stores the high scores of a game and then outputs
 * those scores to a file so that everyone can see the scores.
 */
class High_Score {
    // Instance variables
    String[] high_score_names = new String[6];
    int[] high_score_values = new int[6];

    /**
     * This is the constructor for the High_Score Class
     * which sets both the array of the name and the
     * array of the scores to a default value.
     */
    High_Score(){
        Arrays.fill(high_score_names, "-----------");
        Arrays.fill(high_score_values, 0);
    }

    /**
     * This method checks to see if the player achieved a high score.
     * If the player did achieve a high score then the players name
     * and score will be added to the high scores list and will knock
     * everyone that had a lower score than the player down one rank.
     * @param name This is the players name that the player entered in the game.
     * @param score This is the score achieved by the player after the game ended.
     */
    void playerScore(String name, int score){
        // Temporary instance variables that are declared as arrays.
        String[] temp_score_name = new String[6];
        int[] temp_score_value = new int[6];

        /* This loop goes through the high scores and compares the
        *  players score that the player just achieved from the game.
        *  Then if the player made it to one of the top five scores the
        *  player is added to the high scores array.*/
        for(int k = 0; k < high_score_names.length -1; ++k) {
            if (score > high_score_values[k]) {
                temp_score_name[k] = name;
                temp_score_value[k] = score;

                /* Since the player achieved a high score the loop will
                *  run through the rest of the high score list and fills
                *  out the high scores array eliminating the last high
                *  score that was in the array.*/
                for (int s = k+1; s < high_score_names.length -1; ++s) {
                    System.out.println(s);
                    temp_score_name[s] = high_score_names[s-1];
                    temp_score_value[s] = high_score_values[s-1];
                }
                k = high_score_names.length + 1;
            }
            else{
                // Occurs if the score the player had is less than a high score.
                temp_score_name[k] = high_score_names[k];
                temp_score_value[k] = high_score_values[k];
            }
        }
        high_score_names = temp_score_name;
        high_score_values = temp_score_value;
    }

    /**
     * Allows you to get the array containing the names of the players
     * with the high scores.
     * @return String array which is the array of strings containing
     * the in game names.
     */
    String[] getTopNames(){
        return high_score_names;
    }

    /**
     * Allows you to get the array containing the scores of the players
     * with the high scores.
     * @return integer array which contains the values of the scores that
     * the high score players had.
     */
    int[] getTopScores(){
        return high_score_values;
    }
}
