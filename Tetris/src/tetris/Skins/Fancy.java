/*
 * Copyright (C) 2017 Brendan
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
package tetris.Skins;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import tetris.Block;
import tetris.GameState;
import tetris.P2;
import tetris.Tetromino;

/**
 * This is a fancied up version of the skin with outlines on shaped and the
 * background is a grid with a gradient from top to bottom in the alpha channel.
 *
 * @author Brendan
 */
public class Fancy extends Skin{
    
    public Fancy() {
        super();
        animationFrame = 20;
    }
    
    public int colorIndex = 0; // Index for cycling colors
    // RGB color chanels
    private final int r[] = {255, 50, 128, 83, 255, 190, 51, 242, 202, 255};
    private final int gr[] = {224, 126, 10, 145, 172, 223, 102, 30, 114, 255};
    private final int b[] = {48, 122, 6, 60, 68, 232, 147, 29, 102, 255};
    public int dummyLevel = 0;

    /**
     * paints the row and current Tetromino inside of the GameState gs.
     * This version draws the the blocks with a 1 pixel border around it.
     *
     * @param gs GameState
     * @param g Graphics context
     */
    @Override
    public void paint(GameState gs, Graphics g) {
        coverage[0] = true;
        background(gs, g);
        Tetromino c = gs.currentTet;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        // Loop through blocks inside the stack
        for (Block[] row : gs.stack) {
            coverage[1] = true;
            for (Block bl : row) {
                coverage[2] = true;
                if (bl != null) {
                    coverage[3] = true;
                    // If b is not null draw it
                    g2.setColor(bl.c);  // Sets color from Block b
                    // Draws a 26 x 26 rectangle Block b's X and Y
                    g2.fillRect(bl.x * 26, bl.y * 26, 26, 26);
                    g2.setColor(Color.darkGray);  // Sets color for the border
                    g2.drawRect(bl.x * 26, bl.y * 26, 25, 25);  // Draws the border
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
     * Determines the background based on the level inside of GameState gs.
     * This is a grid with a gradient in the alpha from top to bottom.
     *
     * @param gs The current GameState
     * @param g The Graphics Context
     */
    @Override
    public void background(GameState gs, Graphics g) {
        coverage[11] = true;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        
        for (int i = 0; i < 520; i += 26) {
            coverage[12] = true;
            for (int j = 0; j < 260; j += 26) {
                coverage[13] = true;
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
