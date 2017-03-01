/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import tetris.Block;

/**
 *
 * @author Brendan
 */
public class Tetromino {
    
    public static int lockTime = 20; // Time given before the piece locks on the stack
    public int untilLock = lockTime; // Time until the piece locks
    public boolean locking = false; // Is locking process going on
    
    // The p@[] at index i desicribes the rotations state when rotationState == i. 
    public P2[][] rotations;  // Initialized in constructor
    public int rotationState = 0;
    public P2 current = new P2(50, 0);
    public Color c;
    
    public Tetromino(P2[][] rotatations, boolean shift) {
        this.rotations = rotations;
        this.current.x = shift ? this.current.x+5 : this.current.x;
    }
    
    public void drop(double v, Block[][] stack) {
        // v is the downward velocity
        // stack is the stack
        
        // Check if Tetromino is in locking state
        // If untilLock is 0 call the lock method
        // Decrament untilLock by 1 and don't do anything else
        
        // add v to the y value of current
        // Check if there are any intersections.
        // If there is subtract v and move the blocks down as far as you can
    }
    
    public void horizontalMove(boolean d) {
        // Make sure this is in grid coordinates
        // d is direction False: Left, True: Right
        // Change x by given d.
        // Check for intersections
        // Change x back if there is an intersection
    }
    
    public void rotate(boolean d) {
        // False: counterclockwise (-1), True: clockwise (+1)
        // change rotation state by 1 based off of d
        // check if there are intsersection
        // If there is change rotation state back
    }
    
    public boolean intersect(Block[][] stack) {
        // When our grid coordinates are used to look at inside of block
        // If any of them are not null return false because there is an issue
        return true;
    }
    
    public void paint(Graphics g) {
        // Delegate to the blocks of current
    }
    
    private void lock(Block[][] stack) {
        // Adds blocks in current to stack
        // Calls delete lines in main
    }
}
