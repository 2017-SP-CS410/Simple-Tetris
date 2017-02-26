/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Graphics;
import java.util.Map;
import tetris.rotations.*;

/**
 *
 * @author Brendan
 */
public class Shape {
    Block[] blocks = new Block[4];
    Rotate r;
    public Shape(char c) {
        // c is the string for shape
    }
    
    public boolean drop(double v, Map<Integer[], Block> bs) {
        // v is the downward velocity
        // First check if shape can be locked
        // Delgate to the blocks instance variable move method
        return false;
    }
    public void dropHard(Map<Integer[], Block> bs) {
        // Delegate to drop with high v
    }
    private boolean lock(Map<Integer[], Block> bs) {
        // Checks to see is the shape can be locked
        // If it can add blocks to bs
        return false;
    }
    public void move(int d) {
        // d is direction negative: Left, positive: Right, 0 don't move
        // Delgate to the blocks instance variable move method
    }
    public void rotate(boolean d) {
        // False: counterclockwise, True: clockwise
        // Delegates to the Rotation instance variable
    }
    public void paint(Graphics g) {
        
    }
}
