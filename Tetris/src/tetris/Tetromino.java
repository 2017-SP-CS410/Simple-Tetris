/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

/**
 *
 * @author Brendan
 */
public class Tetromino {
    private static final Map<Character, Integer[][]> TETROMINO_COORDINATES = init_cor();
    private static final Map<Character, Color> TETROMINO_COLORS = init_col();
    
    private static int lockTime = 20;
    
    private int untilLock = 0;
    private boolean locked = false;
    
    private Block[][] rotations = new Block[4][4];
    
    private int rotationState = 0;
    
    private double x, y;
    
    public Tetromino(char c) {
        // c is the string for Tetromino
    }
    
    public void drop(double v, Block[][] stack) {
        // v is the downward velocity
        // stack is the stack
        
        // Use the rotationState with rotations to check stuff
        
        // Check if Tetromino can be locked before moving
        // If it Tetromino does lock call delete lines in main
        
        // If v is larger than the space between the Tetromino and the stack
        // Drop the blocks as far as they can go can go
        
        // Drop blocks in Tetromino by v
    }
    
    public void dropHard(Block[][] stack) {
        // Drops all the blocks to as far as they can go on the stack
    }
    
    public void move(boolean d) {
        // d is direction False: Left, True: Right
        // Make sure to not move the Tetromino past the edges of the Well
    }
    
    public void rotate(boolean d) {
        // False: counterclockwise, True: clockwise
        // change rotation state by 1 based off of d
    }
    
    public void paint(Graphics g) {
        // Uses state and rotations to get the current rotation
    }
    
    private boolean lock(Block[][] stack) {
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
}
