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

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * The methods related to painting that can be changed between different
 * versions of Tetris have been moved into this class which acts a base class
 * for a Templet of Skins
 *
 * @author Team4
 */
public class Skin {

    public static boolean[] coverage = new boolean[16];
    
    public int animationFrame = 20;  // Number of frames for an animation
    public int colorIndex = 0; // Index for cycling colors
    public int animCount = 5;
    public int dummyLevel = 0;
    
    private int r[] = {255, 50, 128, 83, 255, 190, 51, 242, 202, 255};
    private int gr[] = {224, 126, 10, 145, 172, 223, 102, 30, 114, 255};
    private int b[] = {48, 122, 6, 60, 68, 232, 147, 29, 102, 255};

    /**
     * paints the row and current Tetromino inside of the GameState gs.
     * <p>
     * This base version draws the the blocks with a 1 pixel border around it.
     *
     * @param gs GameState
     * @param g Graphics context
     */
    public void paint(GameState gs, Graphics g) {
        coverage[0] = true;
        background(gs, g);
        Tetromino c = gs.currentTet;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        // Loop through blocks inside the stack
        for (Block[] row : gs.stack) {
            coverage[1] = true;
            for (Block b : row) {
                coverage[2] = true;
                if (b != null) {
                    coverage[3] = true;
                    // If b is not null draw it
                    g2.setColor(b.c);  // Sets color from Block b
                    // Draws a 26 x 26 rectangle Block b's X and Y
                    g2.fillRect(b.x * 26, b.y * 26, 26, 26);
                    g2.setColor(Color.darkGray);  // Sets color for the border
                    g2.drawRect(b.x * 26, b.y * 26, 25, 25);  // Draws the border
                }
            }
        }
        /* 
            This loop finds the grab point for each of the blocks in the 
            Tetromino and draws a square and border based of that.
         */
        for (int k = 0; k < 4; k++) {
            coverage[4] = true;
            g2.setColor(c.c);  // Sets the color to the Tetromino color
            // Finds the grab point
            P2 tetBlockGrab = c.current.add((c.rotations[c.rotationState][k]).scale(26));
            // Draws a rectangle based off the block size
            g2.fillRect((int) tetBlockGrab.x, (int) tetBlockGrab.y, 26, 26);
            g2.setColor(Color.darkGray);  // Sets color for the border
            // Draws a border
            g2.drawRect((int) tetBlockGrab.x, (int) tetBlockGrab.y, 25, 25);
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
        coverage[5] = true;
        if (animationFrame <= 0) {
            coverage[6] = true;
            // If the animation is done return true
            return true;
        }

        int[] lines = gs.deletedLines;  // Indecies of deleted lines
        if (animCount <= 0) {
            coverage[7] = true;
            g.setColor(Color.WHITE);
            animCount = 5;
        } else {
            coverage[8] = true;
            g.setColor(Color.BLACK);
        }

        for (int i = 0; i < lines.length; i++) {
            coverage[9] = true;
            if (lines[i] != -1) {
                coverage[10] = true;
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
    public void background(GameState gs, Graphics g) {
        coverage[11] = true;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        
        for (int i = 0; i < 520; i += 26) {
            coverage[12] = true;
            for (int j = 0; j < 260; j += 26) {
                coverage[13] = true;
                System.out.println((int) (255 - (255*((520-i)/520f))));
                g2.setColor(new Color(r[colorIndex],gr[colorIndex],b[colorIndex], (int) (255 - (255*((520-i)/520f)))));
                g2.drawRect(j, i, 25, 25);
            }
        }
        
        if (dummyLevel != gs.level) {
            coverage[14] = true;
            dummyLevel = gs.level;
            if (gs.level % 10 == 0) {
                coverage[15] = true;
                colorIndex = (colorIndex + 1)%r.length;
            }
        }
        
    }
}