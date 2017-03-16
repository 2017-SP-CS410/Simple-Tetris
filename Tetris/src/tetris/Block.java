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

import java.awt.Color;

/**
 * Blocks are used as a wrapper for a x, y position in grid space and a Color c
 *
 * @author Architects
 */
public class Block {

    // Array to keep track of what code has run in this class
    public static boolean[] coverage = new boolean[1];

    // Width and Height of a block
    public static final int WIDTH = 26;
    public static final int HEIGHT = 26;

    // X and Y are on the grid space
    public int x, y;
    public Color c;

    /**
     * Simple Block Constructor
     *
     * @param x X coordinate (grid space)
     * @param y Y coordinate (grid space)
     * @param c Color of specified block
     */
    public Block(int x, int y, Color c) {
        coverage[0] = true;
        this.x = x;
        this.y = y;
        this.c = c;
    }
}
