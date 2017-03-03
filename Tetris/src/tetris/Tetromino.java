/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import tetris.Block;

/**
 *
 * @author Brendan
 */
public class Tetromino {

    // The p@[] at index i desicribes the rotations state when rotationState == i. 
    public P2[][] rotations;  // Initialized in constructor, these are in grid coordinates!!!
    public int rotationState = 0;
    public P2 current;
    public Color c;
    public static boolean[] coverage = new boolean[100];
  
    public Tetromino(P2[][] rotatations, P2 start, Color c) {
        coverage[0] = true;
        this.rotations = rotations;
        this.current = start;
        this.c = c;
    }

    public static Tetromino tetI(P2 start, Color c) {
        // You need to make the other 6 methods!!! 
        //Make a new tetromino the rotation array corresponding 
        //with I and the color C that was given
        coverage[1] = true;
        P2[] pos1 = {new P2(-2, 0), new P2(-1, 0), new P2(0, 0), new P2(1, 0)};
        P2[] pos2 = {new P2(0, -2), new P2(0, -1), new P2(0, 0), new P2(0, 1)};
        P2[] pos3 = {new P2(-1, 0), new P2(0, 0), new P2(0, 1), new P2(0, 2)};
        P2[] pos4 = {new P2(0, -1), new P2(0, 0), new P2(0, 1), new P2(0, 2)};

        P2[][] tet = {pos1, pos2, pos3, pos4};

        return new Tetromino(tet, start, c);
    }

    public static Tetromino tetJ(P2 start, Color c) {
        // You need to make the other 6 methods!!! 
        //Make a new tetromino the rotation array coorisponding 
        //with I and the color C that was given
        coverage[2] = true;
        P2[] pos1 = {new P2(-1, -1), new P2(-1, 0), new P2(0, 0), new P2(1, 0)};
        P2[] pos2 = {new P2(1, -1), new P2(0, -1), new P2(0, 0), new P2(0, 1)};
        P2[] pos3 = {new P2(-1, 0), new P2(0, 0), new P2(1, 0), new P2(1, 1)};
        P2[] pos4 = {new P2(-1, 1), new P2(0, 1), new P2(0, 0), new P2(0, -1)};

        P2[][] tet = {pos1, pos2, pos3, pos4};
        return new Tetromino(tet, start, c);
    }

    public static Tetromino tetL(P2 start, Color c) {
        // You need to make the other 6 methods!!! 
        //Make a new tetromino the rotation array coorisponding 
        //with I and the color C that was given
        coverage[3] = true;
        P2[] pos1 = {new P2(-1, 0), new P2(0, 0), new P2(1, 0), new P2(1, -1)};
        P2[] pos2 = {new P2(0, -1), new P2(0, 0), new P2(0, 1), new P2(1, 1)};
        P2[] pos3 = {new P2(-1, 1), new P2(-1, 0), new P2(0, 0), new P2(1, 0)};
        P2[] pos4 = {new P2(-1, -1), new P2(0, -1), new P2(0, 0), new P2(0, 1)};

        P2[][] tet = {pos1, pos2, pos3, pos4};
        return new Tetromino(tet, start, c);
    }

    public static Tetromino tetO(P2 start, Color c) {
        // You need to make the other 6 methods!!! 
        //Make a new tetromino the rotation array coorisponding 
        //with I and the color C that was given
        coverage[4] = true;
        P2[] pos1 = {new P2(0, 0), new P2(1, 0), new P2(0, 1), new P2(1, 1)};

        P2[][] tet = {pos1};
        return new Tetromino(tet, start, c);
    }

    public static Tetromino tetS(P2 start, Color c) {
        // You need to make the other 6 methods!!! 
        //Make a new tetromino the rotation array coorisponding 
        //with I and the color C that was given
        coverage[5] = true;
        P2[] pos1 = {new P2(-1, 0), new P2(0, 0), new P2(0, -1), new P2(1, -1)};
        P2[] pos2 = {new P2(0, -1), new P2(0, 0), new P2(1, 0), new P2(1, 1)};
        P2[] pos3 = {new P2(-1, 1), new P2(0, 1), new P2(0, 0), new P2(1, 0)};
        P2[] pos4 = {new P2(-1, -1), new P2(-1, 0), new P2(0, 0), new P2(0, 1)};

        P2[][] tet = {pos1, pos2, pos3, pos4};
        return new Tetromino(tet, start, c);
    }

    public static Tetromino tetT(P2 start, Color c) {
        // You need to make the other 6 methods!!! 
        //Make a new tetromino the rotation array coorisponding 
        //with I and the color C that was given
        coverage[6] = true;
        P2[] pos1 = {new P2(-1, 0), new P2(0, 0), new P2(0, 1), new P2(1, 0)};
        P2[] pos2 = {new P2(0, -1), new P2(0, 0), new P2(1, 0), new P2(0, 1)};
        P2[] pos3 = {new P2(-1, 0), new P2(0, 0), new P2(0, 1), new P2(1, 0)};
        P2[] pos4 = {new P2(-1, 0), new P2(0, -1), new P2(0, 0), new P2(0, 1)};

        P2[][] tet = {pos1, pos2, pos3, pos4};
        return new Tetromino(tet, start, c);
    }

    public static Tetromino tetZ(P2 start, Color c) {
        // You need to make the other 6 methods!!! 
        //Make a new tetromino the rotation array coorisponding 
        //with I and the color C that was given
        coverage[7] = true;
        P2[] pos1 = {new P2(-1, -1), new P2(0, -1), new P2(0, 0), new P2(1, 0)};
        P2[] pos2 = {new P2(0, 1), new P2(0, 0), new P2(1, 0), new P2(1, -1)};
        P2[] pos3 = {new P2(-1, 0), new P2(0, 0), new P2(0, 1), new P2(1, 1)};
        P2[] pos4 = {new P2(-1, 1), new P2(-1, 0), new P2(0, 0), new P2(0, -1)};

        P2[][] tet = {pos1, pos2, pos3, pos4};
        return new Tetromino(tet, start, c);
    }

    public boolean drop(GameState gs) {

        // add gravity to the current y position.
        // Check if there are any intersections.
        // If there is subtract gravity and move the blocks down as far as you can
        // The return boolean tells whether the drop resulted in an intersection happening.
        coverage[8] = true;
        P2 p = convPoint();

        double prev = current.y;
        current.y += gs.gravity;
        if (this.intersect(gs)) {
            coverage[9] = true;
            current.y -= gs.gravity;
            for (P2 a : this.rotations[this.rotationState]){
               int newY = (int) (a.y + p.y);
               int newX = (int) (a.y + p.y);
            }

            return true;
        }
        
        
        coverage[10] = true;
        return false;
    }

    public void horizontalMove(boolean d, GameState gs) {
        // Make sure this is in grid coordinates
        // d is direction False: Left, True: Right
        // Change x by given d.
        // Check for intersections
        // Change x back if there is an intersection
        coverage[11] = true;
        double prev = current.x;
        if (d == false) {
            coverage[12] = true;
            current.x = current.x - 10;
        } else if (d == true) {
            coverage[13] = true;
            current.x = current.x + 10;
        }

        if (this.intersect(gs)) {
            coverage[14] = true;
            current.x = prev;
        }
    }

    public void rotate(boolean d, GameState gs) {
        // False: counterclockwise (-1), True: clockwise (+1)
        // change rotation state by 1 based off of d
        // check if there are intsersection
        // If there is change rotation state back
        coverage[15] = true;
        int prev = this.rotationState;
        if (d == false) {
            coverage[16] = true;
            this.rotationState = (this.rotationState - 1) % this.rotations[rotationState].length;
        } else if (d == true) {
            coverage[17] = true;
            this.rotationState = (this.rotationState + 1) % this.rotations[rotationState].length;
        }
        if (this.intersect(gs)) {
            coverage[18] = true;
            this.rotationState = prev;
        }
        // change to conditional assignment ie: http://www.cafeaulait.org/course/week2/43.html        

    }

    public boolean intersect(GameState gs) {
        // When our grid coordinates are used to look at inside of block
        // If any of them are not null return false because there is an issue
        coverage[19] = true;
        P2 p = convPoint();

        for (P2 a : this.rotations[this.rotationState]) {
            coverage[20] = true;
            if (a.x + p.x < 0 || a.x + p.x >= 9 || a.y + p.y >= 21) {
                coverage[21] = true;
                return true;
            }
            if (gs.stack[(int) (a.y + p.y)][(int) (a.x + p.x)] != null) {
                coverage[23] = true;
                return true;

            }

        }
        coverage[24] = true;

        return false;

    }

    public P2 convPoint() {
        coverage[25] = true;
        int gsx = (int) (this.current.x / 26);
        int gsy = (int) Math.ceil(this.current.y / 26);
        return new P2(gsx, gsy);
    }
}
