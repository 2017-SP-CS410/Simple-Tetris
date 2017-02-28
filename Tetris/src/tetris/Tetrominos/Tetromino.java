/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.Tetrominos;

import java.awt.Color;
import java.awt.Graphics;
import tetris.Block;

/**
 *
 * @author Brendan
 */
public class Tetromino {
    
    private int x, y; // Gird coordinates
    private double cy; // This is used to define when y changes
    private static int lockTime = 20; // Time given before the piece locks on the stack
    private int untilLock = lockTime; // Time until the piece locks
    private boolean locking = false; // Is locking process going on
    
    // The Block[] at index i desicribe the rotations state when rotationState == i. 
    // Initialized in subclass.
    protected static Block[][] rotations; 
    protected int rotationState = 0;
    protected Block[] current = new Block[4]; // The actual blocks that you manipulate
    // Make sure to not alias current with anything in rotations
    
    public void drop(double v, Block[][] stack) {
        // v is the downward velocity
        // stack is the stack
        
        // Check if Tetromino is in locking state
        // If untilLock is 0 call the lock method
        // Decrament untilLock by 1 and don't do anything else
        
        // If v is larger than the space between the Tetromino and 
        // what directy below on the stack
        // Drop the blocks as far as they can go can go
        
        // add v to cy and set y to the floor(cy)
        // drop all the block in current by (0, v)
    }
    
    public void dropHard(Block[][] stack) {
        // Drops all the blocks to as far as they can go on the stack
    }
    
    public void move(boolean d) {
        // d is direction False: Left, True: Right
        // Make sure to not move the Tetromino past the edges of the Well
    }
    
    public void rotate(boolean d) {
        // False: counterclockwise (-1), True: clockwise (+1)
        // change rotation state by 1 based off of d
        // replaces current with a new Block[] based off rotations[rotationState]
    }
    
    public void paint(Graphics g) {
        // Delegate to the blocks of current
    }
    
    private void lock(Block[][] stack) {
        // Adds blocks in current to stack
        // Calls delete lines in main
    }
}
