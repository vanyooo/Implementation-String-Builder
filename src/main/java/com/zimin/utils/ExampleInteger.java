package com.zimin.utils;
import java.util.function.Function;

public class ExampleInteger implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer * 2;
    }
}
