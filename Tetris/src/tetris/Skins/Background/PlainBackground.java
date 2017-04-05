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
package tetris.Skins.Background;

import java.awt.Color;
import java.awt.Graphics2D;
import tetris.Block;
import tetris.GameState;

/**
 *
 * @author Brendan
 */
public class PlainBackground implements Background{
    
    public int currentB = 0;
    public Color[] bgs;
    
    public PlainBackground() {
        int r[] = {255, 50, 128, 83, 255, 190, 51, 242, 202, 255};
        int g[] = {224, 126, 10, 145, 172, 223, 102, 30, 114, 255};
        int b[] = {48, 122, 6, 60, 68, 232, 147, 29, 102, 255};
        this.bgs = new Color[10];
        for (int i = 0; i < bgs.length; i++) {
            bgs[i] = new Color(r[i], g[i], b[i]);
        }
    }
    
    public PlainBackground(Color c) {
        this.bgs = new Color[1];
        this.bgs[0] = c;
    }

    public PlainBackground(Color[] bgs) {
        this.bgs = bgs;
    }

    @Override
    public void paint(GameState gs, Graphics2D g) {
        g.setColor(this.bgs[this.currentB]);
        g.fillRect(0, 0, Block.WIDTH * 10, Block.HEIGHT*20);
    }

    @Override
    public void change() {
        this.currentB++;
        this.currentB %= this.bgs.length;
    }
}
