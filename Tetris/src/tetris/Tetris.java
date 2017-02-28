/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import tetronimo.Tetromino;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Brendan
 */
public class Tetris {

    /**
     * @param args the command line arguments
     */
    
    
    private static int score = 0;
    private static Tetromino current_Tet;
    
    
    public static void deleteLines(Block[] bs) {
        // This gets called whenever a Tetromino gets locked it
        
        // If any of the blocks are about the well call game over
        
        // Check to check if any other the blocks passed cause there to be
        // a full line in the stack.
        // If there are delete them and call updateScore with the number of lines
        
        // Call nextShape
    }
    
    public static void nextShape() {
        // replace current_Tet with a new Tetromino
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
