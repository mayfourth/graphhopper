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

import java.io.File;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Peter Karich
 */
public class HelperTest {

    @Before
    public void setUp() {
        Helper.deleteDir(new File("test"));
    }

    @After
    public void tearDown() {
        Helper.deleteDir(new File("test"));
    }

    @Test
    public void testStoreFloats() throws Exception {
        float[] floats = new float[]{1.2f, 1.7f, -129f};
        Helper.writeFloats("test", floats);

        float[] newFloats = Helper.readFloats("test");
        assertArrayEquals(floats, newFloats, 1e-6f);
    }

    @Test
    public void testStoreInt() throws Exception {
        int[] ints = new int[]{12, 17, -129};
        Helper.writeInts("test", ints);

        int[] newInts = Helper.readInts("test");
        assertArrayEquals(ints, newInts);
    }

    @Test
    public void testVERSION() throws Exception {
        // assertTrue(Helper.SNAPSHOT);
        assertNotSame("0.0", Helper.VERSION);
    }

    @Test
    public void testStoreSettings() throws Exception {
        Object[] settings = new Object[]{12, "test", true};
        Helper.writeSettings("test", settings);

        Object[] newSett = Helper.readSettings("test");
        assertArrayEquals(settings, newSett);
    }

    @Test
    public void testUnzip() throws Exception {
        String to = "./target/tmp/test";
        Helper.deleteDir(new File(to));
        Helper.unzip("./src/test/resources/com/graphhopper/util/test.zip", to, false);
        assertTrue(new File("./target/tmp/test/file2 bäh").exists());
        assertTrue(new File("./target/tmp/test/folder1").isDirectory());
        assertTrue(new File("./target/tmp/test/folder1/folder 3").isDirectory());
        Helper.deleteDir(new File(to));
    }
}
