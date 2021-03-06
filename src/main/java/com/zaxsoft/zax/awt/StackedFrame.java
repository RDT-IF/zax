/*
 * Copyright (c) 2008 Matthew E. Kimmel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.zaxsoft.zax.awt;

import java.awt.*;

/**
 * @author Matt Kimmel
 */
class StackedFrame extends java.awt.Frame {
	// Paint all components in the proper order.
	public void paintComponents(Graphics gc)
	{
		Component[] comps;
		Graphics compgc;
		Rectangle b;
		
		comps = getComponents();
		for (int i = (comps.length - 1);i >= 0;i--) {
			if (comps[i] == null)
				continue;
			b = comps[i].bounds();
			compgc = gc.create(b.x,b.y,b.width,b.height);
			comps[i].paintAll(compgc);
			compgc.dispose();
		}
	}

	// Print all components in the proper order.
	public void printComponents(Graphics gc)
	{
		Component[] comps;
		Graphics compgc;
		Rectangle b;
		
		comps = getComponents();
		for (int i = (comps.length - 1);i >= 0;i--) {
			if (comps[i] == null)
				continue;
			b = comps[i].bounds();
			compgc = gc.create(b.x,b.y,b.width,b.height);
			comps[i].printAll(compgc);
			compgc.dispose();
		}
	}
}
