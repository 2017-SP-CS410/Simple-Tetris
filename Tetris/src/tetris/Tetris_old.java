/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author Brendan
 */
public class Tetris_old {

    /**
     * @param args the command line arguments
     */
    
    private static Block[][] stack = new Block[22][10];
    private static int score = 0;
    private static Tetromino currentTet;
    private static int level = 0;
    private static double gravity = 0;
    private static boolean animation = false;
    
    public static void deleteLines(Block[] bs) {
        // This gets called whenever a Tetromino gets locked it
        
        // If any of the blocks are about the well call game over
        
        // Check to check if any other the blocks passed cause there to be
        // a full line in the stack.
        // If there are delete them and call updateScore with the number of lines
        
        // Call nextTetromino with a boolean of whether lines where cleared or not
    }
    
    public static void nextTetromino(boolean cleared) {
        // replace current_Tet with a new Tetromino
        // Increase Level If level % 100 != 99 (unless cleared)
        // Increase Gravity by 2% of Max gravity for this block of levels
    }
    
    public static void updateScore(int lines) {
        // Updates the score based on the number of lines cleared
    }
    
    public static void gameOver(boolean win) {
        // This is the Game Over Sequence
        // The Boolean win is used to discribe if the game has been won or lost
    }
    
    public static void main(String[] args) {
        
    }
}
