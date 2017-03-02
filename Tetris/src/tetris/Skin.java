/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Graphics;

/**
 *
 * @author Brendan
 */
public class Skin {
    public int animationFrame;
    
    public void paint(gameState gs, Graphics g) {
        // Draw the Tetromino inside of gs
        // Draw all the blocks in the stack in gs
    }
    
    public boolean animate(gameState gs, Graphics g) {
        // If animationFrame == 0 return true. Animation is done
        // Else decrement animationFrame
        // Do animation thing
        return false;
    }
    
    public void background(gameState gs) {
        // Change the background based on the level inside of gs
    }
}
