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
package com.graphhopper.routing;

import com.graphhopper.routing.util.WeightCalculation;
import com.graphhopper.util.NotThreadSafe;

/**
 * Calculates the shortest path from the specified node ids. An implementation is not required to
 * make an instance thread safe.
 *
 * @author Peter Karich,
 */
@NotThreadSafe
public interface RoutingAlgorithm {

    /**
     * Calculates the fastest or shortest path.
     *
     * @return Path.NOT_FOUND if nothing was found
     */
    Path calcPath(int from, int to);

    RoutingAlgorithm setType(WeightCalculation calc);

    RoutingAlgorithm clear();
}
