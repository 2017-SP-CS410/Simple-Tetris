/*
 * Copyright (C) 2017
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tetris;

import java.awt.Graphics;
import java.awt.Color;

/**
 * The methods related to painting that can be changed between different
 * versions of Tetris have been moved into this class which acts a base class
 * for a Templet of Skins
 *
 * @author Team4
 */
public class Skin {

    public int animationFrame = 20;  // Number of frames for an animation
    // I don't think this is needed you can animationFrame % 5.
    private int animCount = 5;

    /**
     * paints the row and current Tetromino inside of the GameState gs.
     * <p>
     * This base version draws the the blocks with a 1 pixel border around it.
     *
     * @param gs GameState
     * @param g Graphics context
     */
    public void paint(GameState gs, Graphics g) {
        Tetromino c = gs.currentTet;
        // Loop through blocks inside the stack
        for (Block[] row : gs.stack) {
            for (Block b : row) {
                if (b != null) {
                    // If b is not null draw it
                    g.setColor(b.c);  // Sets color from Block b
                    // Draws a 26 x 26 rectangle Block b's X and Y
                    g.fillRect(b.x * 26, b.y * 26, 26, 26);
                    g.setColor(Color.BLACK);  // Sets color for the border
                    g.drawRect(b.x * 26, b.y * 26, 25, 25);  // Draws the border
                }
            }
        }
        /* 
            This loop finds the grab point for each of the blocks in the 
            Tetromino and draws a square and border based of that.
         */
        for (int k = 0; k < 4; k++) {
            g.setColor(c.c);  // Sets the color to the Tetromino color
            // Finds the grab point
            P2 tetBlockGrab = c.current.add((c.rotations[c.rotationState][k]).scale(26));
            // Draws a rectangle based off the block size
            g.fillRect((int) tetBlockGrab.x, (int) tetBlockGrab.y, 26, 26);
            g.setColor(Color.BLACK);  // Sets color for the border
            // Draws a border
            g.drawRect((int) tetBlockGrab.x, (int) tetBlockGrab.y, 25, 25);
        }
    }

    /**
     * This is the animation of lines disappearing and is called every frame The
     * boolean that is returned is to tell the function that calls animate if
     * the animation is done or not.
     * <p>
     * This basic version just blinks the rows black and white
     *
     * @param gs The current GameState
     * @param g The Graphics context
     * @return The boolean to say if the animation is done or not
     */
    public boolean animate(GameState gs, Graphics g) {
        if (animationFrame <= 0) {
            // If the animation is done return true
            return true;
        }

        int[] lines = gs.deletedLines;  // Indecies of deleted lines
        if (animCount <= 0) {
            g.setColor(Color.WHITE);
            animCount = 5;
        } else {
            g.setColor(Color.BLACK);
        }
        // TODO use an itterator loop here
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] != -1) {
                g.fillRect(0, lines[i] * 26, 260, 26);
            }
        }
        animCount--;
        animationFrame--;
        return false;
    }

    /**
     * Determines the background based on the level inside of GameState gs
     * 
     * @param gs The current GameState
     */
    public void background(GameState gs) {
        
    }
}
