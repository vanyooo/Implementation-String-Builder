package com.zimin.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ArrayUtils {

    public static <T> T[] arrayMapping(T[] array, Function<T, T> function) {

        T[] result = array.clone();

        Arrays.stream(array)
                .map(function)
                .toList()
                .toArray(result);

        return result;
    }

    public static <T> Map<T, Integer> countOccurrences(T[] array) {
        Map<T, Integer> map = new HashMap<>();

        for (T element : array) {

            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }

        return map;
    }
}
