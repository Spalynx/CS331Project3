import java.util.Arrays;
/**
 * Last Modified by Brandon Hathaway on 4/7/2016.
 */

/**
 * This class stores the high scores of a game and then outputs
 * those scores to a file so that everyone can see the scores.
 */
public class High_Score {
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
