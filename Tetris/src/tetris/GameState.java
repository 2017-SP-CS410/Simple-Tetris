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
import java.awt.Graphics;

/**
 * Holds all the variables and methods used in the game and that make it go.
 *
 * @author Team1
 */
public class GameState {

    // Array to keep track of what code has run in this class
    public static boolean[] coverage = new boolean[50];

    // Enum of the posible states
    public enum State {
        falling, locking, animation, paused
    }

    public int score = 0;
    public int level = 0;
<<<<<<< Updated upstream
    public double gravity = 2.6;
=======
    public double gravity = 20;
>>>>>>> Stashed changes
    public State state;
    public int untilLock = 20;  // Time until a Tetromino is locked
    // Array of lines that need to be deleted
    public int deletedLines[] = {-1, -1, -1, -1};
    public GamePlay gp;
    public Skin s;
    public Block[][] stack = new Block[22][10];
    public Tetromino currentTet;

    /**
     * Constructor for GameState
     *
     * @param gp GamePlay object for the GameState
     * @param s Skin object for the GameState
     */
    public GameState(GamePlay gp, Skin s) {
        coverage[0] = true;
        this.gp = gp;
        this.s = s;
        gp.nextTet(this);  // Produce the first Tetromino
        this.state = State.falling;  // Set the state to falling
    }

    /**
     * This drops or locks the Tetromino based on the state. If the state is
     * falling then only drop is called If the state is locking one of two
     * things happens. 1) The Tetronimo is not ready to lock so the untilLock is
     * decremented 2) The Tetromino is ready to lock so it locks the Tetromino
     * and sets the state to animation is it results in lines being deleted
     */
    public void tick() {
        coverage[1] = true;

        if (state == State.falling) {
            coverage[2] = true;
            drop();
        } else if (state == State.locking) {
            coverage[3] = true;
            if (untilLock != 0) {
                coverage[4] = true;
                untilLock--;
            } else if (untilLock == 0) {
                coverage[5] = true;
                untilLock = 20;
                lock();
                boolean deleted = deleteLines();
                if (deleted) {
                    coverage[6] = true;
                    state = State.animation;
                } else {
                    coverage[7] = true;
                    state = State.falling;
                    gp.nextTet(this);
                }
            }
        }

    }

    /**
     * Simply delegates to the Tetromino's drop and sets the state if the
     * Tetromino's drop returns true
     */
    public void drop() {
        coverage[8] = true;

        if (currentTet.drop(this)) {
            coverage[9] = true;
            state = State.locking;
        }

    }

    /**
     * Breaks apart the Tetromino into a set of blocks that are then placed into
     * the stack
     */
    public void lock() {
        coverage[10] = true;

        // Local grid coordinates of the blocks in the current rotation
        P2[] rot = currentTet.rotations[currentTet.rotationState];
        // Global position of the Tetromino in grid coordinates
        P2 gridP = currentTet.convPoint();

        for (int i = 0; i < rot.length; i++) {
            // Global X, Y coordinate of the current block
            int x = (int) (rot[i].x + gridP.x);
            int y = (int) (rot[i].y + gridP.y);
            stack[y][x] = new Block(x, y, currentTet.c);
        }
    }

    /**
     * Finds all of the full rows in the stack and adds the indeces of those
     * rows to the deletedLines array and tells the method that called it if
     * lines need to be deleted or not.
     *
     * @return Boolean to say if lines need to be deleted or not
     */
    public boolean deleteLines() {
        coverage[11] = true;

        resetLines();  // Resets the deletedLines array to -1

        int index = 0;  // Index of deletedLines

        for (int i = 0; i < stack.length; i++) {
            int numBlk = 0;  // Blocks in the row
            for (int j = 0; j < stack[i].length; j++) {
                if (stack[i][j] != null) {
                    coverage[12] = true;
                    numBlk++;
                }
            }
            if (numBlk == 10) {
                coverage[13] = true;
                deletedLines[index] = i;
                index++;
            }
        }
        if (index > 0) {
            coverage[14] = true;
            update(index);  // Updates the score based on the lines cleared
            return true;
        }
        return false;
    }

    /**
     * Delegates to the GamePlay gp update method.
     *
     * @param lines Number of Lines cleared
     */
    public void update(int lines) {
        coverage[15] = true;
        gp.update(this, lines);
    }

    /**
     * Delegates the Tetromino currentTet horizontalMove method
     *
     * @param dirc Direction to move False: Left, True: Right
     */
    public void horizontalMove(boolean dirc) {
        coverage[16] = true;
        currentTet.horizontalMove(dirc, this);
    }

    /**
     * Delegates to the Tetromino currentTet rotate method
     *
     * @param dirc Direction to rotate False: counter-clockwise, True: clockwise
     */
    public void rotate(boolean dirc) {
        coverage[17] = true;
        currentTet.rotate(dirc, this);
    }

    /**
     * Delegates to the Skin paint and animate methods. In the event that
     * animate returns true then move all the blocks down, create the next
     * Tetromino and set the state back to falling.
     *
     * @param g The Graphics context
     */
    public void paint(Graphics g) {
        coverage[18] = true;
        s.paint(this, g);

        if (state == State.animation) {
            coverage[19] = true;
            if (s.animate(this, g)) {
                coverage[20] = true;
                for (int i : deletedLines) {
                    if (i != -1) {
                        for (int k = i; k <= 0; k--) {
                            for (int j = 0; j < 10; j++) {
                                if (stack[k][j] != null) {
                                    stack[k][j] = stack[k - 1][j];
                                    stack[k][j].y -= 1;
                                }
                            }
                        }
                    }
                }
                gp.nextTet(this);
                state = State.falling;
            }
        }
    }

    /**
     * Re-initialized deletedLines to -1
     */
    public void resetLines() {
        coverage[23] = true;
        for (int i = 0; i < deletedLines.length; i++) {
            deletedLines[i] = -1;
        }
    }

    /**
     * Test function for filling the well
     */
    public void testWell() {
        coverage[21] = true;
        for (int i = 0; i < stack.length; i++) {
            for (int j = 0; j < stack[i].length; j++) {
                stack[i][j] = new Block(j, i, Color.red);
            }
        }
    }

    /**
     * Test function for testing animation
     */
    public void testAnim() {
        coverage[22] = true;
        deletedLines[0] = 3;
        state = State.animation;
    }
}
