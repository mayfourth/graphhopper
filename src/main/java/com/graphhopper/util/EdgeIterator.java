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
package com.graphhopper.util;

/**
 * Iterates through all edges of one node. Avoids object creation in-between via direct access
 * methods. These methods can be implemented as lazy fetching but often this will be avoid to "fetch
 * the properties as a whole" (benefits for transactions, locks, etc)
 *
 * Usage:
 * <pre>
 * // calls to iter.node(), distance() without next() will cause undefined behaviour
 * while(iter.next()) {
 *   int nodeId = iter.node();
 *   ...
 * }
 *
 * @author Peter Karich
 */
public interface EdgeIterator {

    /**
     * To be called to go to the next edge
     */
    boolean next();

    /**
     * @return the edge id of the current edge
     */
    int edge();

    /**
     * @return the node id of the origin node. Identical for all edges of this iterator.
     */
    int fromNode();

    /**
     * @return the node id of the destination node for the current edge.
     */
    int node();

    /**
     * @return the distance of the current edge edge
     */
    double distance();

    int flags();
    
    boolean isEmpty();
    public static final int NO_EDGE = -1;   
}
