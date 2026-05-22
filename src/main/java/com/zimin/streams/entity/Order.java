package com.zimin.streams.entity;

public record Order(String product, double cost) {

    @Override
    public String toString() {
        return "product='" + product + '\'' +
                '}';
    }
}