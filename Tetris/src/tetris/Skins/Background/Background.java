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

import tetris.GameState;
import java.awt.Graphics2D;

/**
 *
 * @author Brendan
 */
public interface Background {
    
    public void paint(GameState gs, Graphics2D g);
    
    public void change();
}
