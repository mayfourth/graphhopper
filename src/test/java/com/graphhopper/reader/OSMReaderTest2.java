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
package com.graphhopper.reader;

/**
 * @author Peter Karich
 */
public class OSMReaderTest2 extends OSMReaderTest {

    @Override
    OSMReader preProcess(OSMReader osmreader) {
        osmreader.setDoubleParse(true);
        osmreader.getHelper().preProcess(getClass().getResourceAsStream("test-osm.xml"));
        return osmreader;
    }
}
