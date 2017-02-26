/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.rotations;

import tetris.Block;

/**
 *
 * @author Brendan
 */
public abstract class Rotate {
    public abstract void rotate(boolean d, Block[] bs);
    public void kick(Block[] rotated) {
        // Takes a set of rotated blocks and looks if it can be kicked
    }
}
