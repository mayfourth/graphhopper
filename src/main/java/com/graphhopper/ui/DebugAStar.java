/*
 *  Copyright 2012 Peter Karich 
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.graphhopper.ui;

import com.graphhopper.routing.AStar;
import com.graphhopper.storage.EdgeEntry;
import com.graphhopper.storage.Graph;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author Peter Karich
 */
public class DebugAStar extends AStar implements DebugAlgo {

    private MyGraphics mg;
    private Graphics2D g2;

    public DebugAStar(Graph graph, MyGraphics mg) {
        super(graph);
        this.mg = mg;
    }

    @Override
    public void setGraphics2D(Graphics2D g2) {
        this.g2 = g2;
    }

    @Override public void updateShortest(EdgeEntry shortestDE, int currLoc) {
        if (g2 != null)
            mg.plotNode(g2, currLoc, Color.YELLOW);
        super.updateShortest(shortestDE, currLoc);
    }
}
