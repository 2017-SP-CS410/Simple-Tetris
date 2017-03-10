package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
    
    //Width and Height of a block. May change when GUI is being made
    private static final int WIDTH  = 10;
    private static final int HEIGHT = 10;

    // X and Y are on a grid system based block width and height 
    public int x, y;
    public Color c;

    public Block(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
    
//    public void paint(Graphics g) {
//        // Grid coordinate -> Screen coordinate
//        // (x*Width,y*Height)
//    }
}
