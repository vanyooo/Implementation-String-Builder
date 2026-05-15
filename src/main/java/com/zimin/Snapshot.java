package com.zimin;

import java.util.Arrays;

public class Snapshot {

    final char[] value;
    final int count;

    public Snapshot(char[] value, int count) {
        this.value = Arrays.copyOf(value, value.length);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public char[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Snapshot{" +
                "value=" + Arrays.toString(value) +
                ", count=" + count +
                '}';
    }
}
