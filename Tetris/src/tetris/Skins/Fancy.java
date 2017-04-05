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
import tetris.Skins.Background.GridBackground;
import tetris.Tetromino;

/**
 * This is a fancied up version of the skin with outlines on shaped and the
 * background is a grid with a gradient from top to bottom in the alpha channel.
 *
 * @author Brendan
 */
public class Fancy extends Skin {

    public Fancy() {
        super();
        this.animationFrame = 27;
        this.b = new GridBackground();
    }

    /**
     * paints the row and current Tetromino inside of the GameState gs. This
     * version draws the the blocks with a 1 pixel border around it.
     *
     * @param gs GameState
     * @param g Graphics context
     */
    @Override
    public void paint(GameState gs, Graphics g) {
        b.paint(gs, (Graphics2D) g);
        Tetromino c = gs.currentTet;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        // Loop through blocks inside the stack
        for (Block[] row : gs.stack) {
            for (Block bl : row) {
                if (bl != null) {
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

    @Override
    public boolean animate(GameState gs, Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));

        for (int i : gs.deletedLines) {
            if (i != -1) {
                g2.setColor(Color.black);
                g2.fillRect(0, i * Block.WIDTH, Block.WIDTH * 10, Block.WIDTH);
                if (animationFrame > 0) {
                    for (Block b : gs.stack[i]) {
                        g2.setColor(b.c);
                        g2.fillRect(b.x * Block.WIDTH,
                                b.y * Block.WIDTH + (Block.WIDTH - animationFrame),
                                Block.WIDTH, animationFrame);
                        g2.setColor(Color.darkGray);
                        g2.drawRect(b.x * Block.WIDTH,
                                b.y * Block.WIDTH + (Block.WIDTH - animationFrame),
                                Block.WIDTH, Math.abs(animationFrame - 1));
                    }
                }
            }
        }
        if (animationFrame <= 0) {
            animationFrame = 27;
            return true;
        }
        animationFrame--;
        return false;
    }
}
