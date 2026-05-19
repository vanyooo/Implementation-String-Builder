package com.zimin.utils;

import java.util.function.Function;

public class ExampleString implements Function<String, String> {

    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }
}