/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author Brendan
 */
public class Skin {
    public int animationFrame;
    
    public void paint(GameState gs, Graphics g) {
        Tetromino c = gs.currentTet;
        // This forLoop grabs all blocks in stack and
        for (Block[] stack : gs.stack) {
            for (Block b : stack) {
                g.setColor(b.c); // Sets color from Block b
                g.fillRect(b.x * 26, b.y * 26, 26, 26);// Draws a 26 x 26 rectangle Block b's X and Y
                g.setColor(Color.BLACK);
                g.drawRect(b.x * 26, b.y * 26, 25, 25);
            }
        }
        // This forLoop creates local coordinate Grabpoints then rectangles from CurrentTet
        for (int k = 0; k < 4; k++) {
            g.setColor(c.c);
            P2 tetBlockGrab = c.current.add((c.rotations[c.rotationState][k]).scalar(26));
            g.fillRect((int)tetBlockGrab.x, (int)tetBlockGrab.y, 26, 26);
            g.setColor(Color.BLACK);
            g.drawRect((int)tetBlockGrab.x, (int)tetBlockGrab.y, 25, 25);
        }

        // Draw the Tetromino inside of gs
        // Draw all the blocks in the stack in gs
    }
    
    public boolean animate(GameState gs, Graphics g) {
        // If animationFrame == 0 return true. Animation is done
        // Else decrement animationFrame
        // Do animation thing
        return false;
    }
    
    public void background(GameState gs) {
        // Change the background based on the level inside of gs
    }
}
