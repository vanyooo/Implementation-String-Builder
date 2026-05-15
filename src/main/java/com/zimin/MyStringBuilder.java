package com.zimin;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public final class MyStringBuilder {

    private char[] value;
    private int count;
    private static final int DEFAULT_CAPACITY = 16;

    private final Deque<Snapshot> history = new ArrayDeque<>();

    public MyStringBuilder() {
        value = new char[DEFAULT_CAPACITY];

    }

    public MyStringBuilder(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        value = new char[capacity];
    }

    public MyStringBuilder(String string) {

        if (string == null) {
            string = "null";
        }

        int length = string.length();
        value = new char[length + DEFAULT_CAPACITY];
        string.getChars(0, length, value, 0);
        count = length;
    }

    public int length() {
        return count;
    }

    public MyStringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    public MyStringBuilder append(String string) {

        if (string == null) {
            string = "null";
        }
        saveHistory();

        int len = string.length();
        ensureCapacityInternal(count + len);
        string.getChars(0, len, value, count);
        count += len;
        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity) {

        int oldCapacity = value.length;

        if (minimumCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2 + 2;
            if (newCapacity < minimumCapacity) {
                newCapacity = minimumCapacity;
            }
            value = Arrays.copyOf(value, newCapacity);
        }
    }

    public MyStringBuilder reverse() {

        saveHistory();
        int left = 0;
        int right = count - 1;

        while (left < right) {
            char temp = value[left];
            value[left] = value[right];
            value[right] = temp;
            left++;
            right--;
        }
        return this;
    }

    public MyStringBuilder delete(int start, int end) {

        saveHistory();
        int count = this.count;
        if (end > count) {
            end = count;
        }
        checkRange(start, end, count);
        int len = end - start;
        if (len > 0) {
            shift(end, -len);
            this.count = count - len;
        }

        return this;
    }

    public MyStringBuilder insert(int offset, String str) {
        if (offset < 0 || offset > count) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        saveHistory();
        if (str == null) {
            str = "null";
        }
        int len = str.length();
        ensureCapacityInternal(count + len);
        shift(offset, len);
        str.getChars(0, len, value, offset);
        count += len;
        return this;
    }

    public void undo() {
        if (!history.isEmpty()) {
            Snapshot snapshot = history.pollLast();
            value = Arrays.copyOf(
                    snapshot.getValue(),
                    snapshot.getValue().length
            );
            count = snapshot.getCount();
        }
    }

    private void checkRange(int fromIndex, int toIndex, int length) {
        if (fromIndex < 0 || fromIndex > toIndex || toIndex > length)
            throw new StringIndexOutOfBoundsException();
    }

    private void shift(int offset, int n) {
        System.arraycopy(
                value,
                offset,
                value,
                offset + n,
                count - offset
        );
    }

    private void saveHistory() {
        history.addLast(
                new Snapshot(value, count)
        );
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}
