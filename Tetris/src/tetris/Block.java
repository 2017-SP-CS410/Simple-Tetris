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

    //X and Y are not screen coordinates but game coordinates 
    public int x, y;
    public Color c;

    public Block(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
    
    public void move(int x, int y) {
        // Adds to instance variables x, y
    }
    
    public void paint(Graphics g) {
        
    }

}
