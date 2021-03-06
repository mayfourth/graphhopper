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
package com.graphhopper.coll;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.set.hash.TIntHashSet;

/**
 *
 * @author Peter Karich,
 */
public class MyTBitSet implements MyBitSet {

    private final TIntHashSet tHash;

    public MyTBitSet(int no) {
        tHash = new TIntHashSet(no, 0.7f, -1);
    }

    public MyTBitSet() {
        this(1000);
    }

    @Override public boolean contains(int index) {
        return tHash.contains(index);
    }

    @Override public void add(int index) {
        tHash.add(index);
    }

    @Override public String toString() {
        return tHash.toString();
    }

    @Override
    public int getCardinality() {
        return tHash.size();
    }

    @Override
    public void clear() {
        tHash.clear();
    }

    @Override
    public void ensureCapacity(int index) {
    }

    @Override
    public MyBitSet copyTo(MyBitSet bs) {
        bs.clear();
        if (bs instanceof MyTBitSet) {
            ((MyTBitSet) bs).tHash.addAll(this.tHash);
        } else {
            TIntIterator iter = tHash.iterator();
            while (iter.hasNext()) {
                bs.add(iter.next());
            }
        }
        return bs;
    }

    @Override
    public int next(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
