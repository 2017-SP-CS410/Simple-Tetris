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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import tetris.GameState;

/**
 *
 * @author Brendan
 */
public class GridBackground extends PlainBackground{
    
    public GridBackground() {
        super();
    }
    
    public GridBackground(Color c) {
        super(c);
    }
    
    public GridBackground(Color[] bgs) {
        super(bgs);
    }
    
    @Override
    public void paint(GameState gs, Graphics2D g) {
        g.setStroke(new BasicStroke(2));

        for (int i = 0; i < 520; i += 26) {
            for (int j = 0; j < 260; j += 26) {
                Color c = this.bgs[this.currentB];
                g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(),
                                (int) (255 - (255 * ((520 - i) / 520f)))));
                g.drawRect(j, i, 25, 25);
            }
        }
    }
}
