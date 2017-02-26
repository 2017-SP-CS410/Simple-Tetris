/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class Block {

    int x, y;
    Color c;

    public Block(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public void paint(Graphics g) {
        
    }

    public void drop(double v) {
        // v is the downward velocity
    }

    public void delete() {
        // set yourself to null
    }

    public void move(int d) {
        // d is direction negative: Left, positive: Right, 0 don't move
    }

}
