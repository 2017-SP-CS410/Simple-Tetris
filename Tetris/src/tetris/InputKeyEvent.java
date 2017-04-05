/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import tetris.Skins.Skin;
import tetris.Skins.Fancy;

/**
 *
 * @author JesseRichmond
 */
public class InputKeyEvent extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case (KeyEvent.VK_LEFT):
                gui.gs.horizontalMove(false);
                break;
            case (KeyEvent.VK_RIGHT):
                gui.gs.horizontalMove(true);
                break;
            case (KeyEvent.VK_A):
                gui.gs.rotate(false);
                break;
            case (KeyEvent.VK_D):
                gui.gs.rotate(true);
                break;
            case (KeyEvent.VK_SPACE):
                gui.gs.drop(1000);
                break;
            case (KeyEvent.VK_R):
                gui.gs.stack = new Block[20][10];
                break;
            case (KeyEvent.VK_T):
                if (gui.gs.s instanceof Fancy) {
                    gui.gs.s = new Skin();
                }
                else if (gui.gs.s instanceof Skin) {
                    gui.gs.s = new Fancy();
                }
        }
    }
}
