/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetronimo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;
import tetris.Block;


/**
 *
 * @author Brendan
 */
public class Tetromino {
    private static final int LOCK_TIME = 20;
    
    private int untilLock = 0;
    private boolean locked = false;
    
    public int[][] blockGrid;
    public boolean state;
    public Block[] blocks = new Block[4];
    public Rotate r;
    public Tetromino(char c) {
        // c is the string for Tetromino
    }
    
    public void drop(double v, Map<Integer[], Block> bs) {
        // v is the downward velocity
        // bs is the stack
        
        // Check if Tetromino can be locked before moving
        // If it Tetromino does lock call delete lines in main
        
        // If v is larger than the space between the Tetromino and the stack
        // Drop the blocks as far as they can go can go
        
        // Drop blocks in Tetromino by v
    }
    
    public void dropHard(Map<Integer[], Block> bs) {
        // Drops all the blocks to as far as they can go on the stack
    }
    
    public void move(boolean d) {
        // d is direction False: Left, True: Right
        // Make sure to not move the Tetromino past the edges of the Well
    }
    
    public void rotate(boolean d) {
        // False: counterclockwise, True: clockwise
        // Delegates to the Rotation instance variable
    }
    
    public void paint(Graphics g) {
        
    }
    
    private boolean lock(Map<Integer[], Block> bs) {
        // Checks to see is the Tetromino can be locked
        // If it can check if untilLock == LOCK_TIME
        // If untilLock == LOCK_TIME add pieces to bs and return true
        // else add 1 to untilLock and return false
        return false;
    }
    
    private static Map<Character, Integer[][]> init_cor() {
        // Initializer for TETROMINO_COORDINATES
        return null;
    }
    
    private static Map<Character, Color> init_col() {
        // Initializer for TETROMINO_COLORS
        return null;
    }
    
    private static Map<Character, Rotate> init_rot() {
        // Initializer for TETROMINO_ROTATIONS
        return null;
    }
}
