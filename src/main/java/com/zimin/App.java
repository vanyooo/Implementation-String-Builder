package com.zimin;

import com.zimin.utils.ArrayUtils;
import com.zimin.utils.ExampleInteger;
import com.zimin.utils.ExampleString;

import java.util.Arrays;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        Integer[] ar = {1, 2, 3, 4, 5, 2, 3, 8, 8, 8, 8, 8};
        String[] array = {"a", "b", "a"};

        ExampleString exampleString = new ExampleString();
        String[] result = ArrayUtils.arrayMapping(array, exampleString);
        System.out.println(Arrays.toString(result));

        ExampleInteger exampleInteger = new ExampleInteger();
        Integer[] integers = ArrayUtils.arrayMapping(ar, exampleInteger);
        System.out.println(Arrays.toString(integers));

        Map<Integer, Integer> integerIntegerMap = ArrayUtils.countOccurrences(ar);
        System.out.println(integerIntegerMap);

        System.out.println(ArrayUtils.countOccurrences(array));
    }
}
