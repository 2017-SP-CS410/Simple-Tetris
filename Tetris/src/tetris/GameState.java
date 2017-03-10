
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author micalinscheid
 */
public class GameState {
    public enum State{
        falling, locking, animation, paused
    }

    public int score = 0;
    public int level = 0;
    public double gravity = .01;
    public State state;
    public int untilLock = 20;
    public int deletedLines[] = new int[4];
    // TODO
    public GamePlay gp;
    public Skin s;
    public Block[][] stack = new Block[22][10];
    public Tetromino currentTet;
    
    public GameState (GamePlay gp, Skin s) {
        this.gp = gp;
        this.s = s;
        gp.nextTet(this);
        this.state = State.falling;
    }

    public void tick() {
        // If state is falling call drop
        // Else if state is locking then check if untilLock != 0. Decrement by 1
        // Else if untilLock == 0. Call lock and deleteLines
        // If deleteLines returns true set state to animation
        // If it returns false set game state to falling and call newTet

        if (state == State.falling) {
            drop();
        } else if (state == State.locking) {
            if (untilLock != 0) {
                untilLock--;
            } else if (untilLock == 0) {
                lock();
                deleteLines();
                if (deleteLines() == true) {
                    state = State.animation;
                } else if (deleteLines() == false) {
                    state = State.falling;
                    gp.nextTet(this);
                }
            }
        }

    }

    public void drop() {
        // Delegates to the Tetronimo's drop. If that returns true set state to locking

        if (currentTet.drop(this) == true) {
            state = State.locking;
        }

    }

    public void lock() {
        // Breaks apart Tetromino into a bunch of Blocks and puts them into the stack
        //use convPoint to get grid coordinates instead of screen coordinates
        //use rotation state instance variable to get the rotation
        //add point from ln 48 to all points in line 49 
        //creates new coordinates to give each block
        //add to stack  

        P2[] rot = currentTet.rotations[currentTet.rotationState];
        P2 gridP = currentTet.convPoint();

        for (int i = 0; i < rot.length; i++) {
            double x = rot[i].x + gridP.x;
            double y = rot[i].y + gridP.y;
            stack[(int) y][(int) x] = new Block((int) x, (int) y, currentTet.c);

            // for(int j = 0; j< stack.length; j++){
            //     for(int k = 0; k < stack[j].length; k++){
            //     }
            // }
        }

    }

    public boolean deleteLines() {
        // Find all the lines that needed to be deleted
        // Add those line numbers to deletedLines
        // return True if any lines where deleted else false

        //honestly don't know exactly what to do here.
        int numBlk = 0;
        int index = 0;
        Block b;

        for (int i = 0; i < stack.length; i++) {
            for (int j = 0; j < stack[i].length; j++) {
                if (stack[i][j] != null) {
                    numBlk++;
                }
            }
            if (numBlk == 10) {
                deletedLines[index] = i;
                index++;
            }
        }
        if (index > 0) {
            return true;
        }

        return false;
    }

    public void update(int lines) {
        // Updates score based on line
        lines += deletedLines.length;
    }

    public void horiziontalMove(boolean dirc) {
        // dirc is direction False: Left, True: Right
        // Delegates to Tetromions horizontalMove
        currentTet.horizontalMove(dirc, this);

    }

    public void rotate(boolean dirc) {
        // dirc is direction False: counterclockwise, True: clockwise
        // Delegates to Tetromions rotate
        currentTet.rotate(dirc, this);
    }

    public void paint(Graphics g) {
        // Tell the Skin object to paint
        // If the state is animation
        // Tell Skin object to animate
        // if the animation returns true move everything in the stack above the deletedlines down
        // and call nextTet
        s.paint(this, g);

        if (state.animation == State.animation) {
            if (s.animate(this, g)) {

                for (int i : deletedLines) {
                    for (int k = i; k <= 0; k--) {
                        for (int j = 0; j < 10; j++) {
                            stack[k][j] = stack[k-1][j];
                            stack[k][j].y -= 1;
                    }
                }
            }

                gp.nextTet(this);
                state = State.falling;

            }
        }
    }
    
    public void testWell() {
        for (int i = 0; i < stack.length; i++) {
            for (int j = 0; j < stack[i].length; j++) {
                stack[i][j] = new Block(j, i, Color.red);
            }
        }
    }
}
