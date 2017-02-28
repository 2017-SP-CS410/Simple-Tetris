/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
    
    //Width and Height of a block. May change when GUI is being made
    private static final int WIDTH  = 10;
    private static final int HEIGHT = 10;
    
    // cy is the y value that is used to caculate
    // the next y value when drop is called
    private double cy;

    //X and Y are not screen coordinates but game coordinates 
    public int x, y;
    public Color c;

    public Block(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public void drop(double v) {
        // v is the downward velocity
    }
    
    public void drop(int l) {
        // l is the number of lines to drop the block
    }
    
    public boolean move(boolean d) {
        // d is direction True: right, False: left
        // Returns if the move was sucsessful
        return false;
    }
    
    public void paint(Graphics g) {
        
    }

}
