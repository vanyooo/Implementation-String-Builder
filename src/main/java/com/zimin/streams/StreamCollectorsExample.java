package com.zimin.streams;

import com.zimin.streams.entity.Order;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class StreamCollectorsExample {

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Headphones", 200.0),
                new Order("Headphones", 100.0),
                new Order("PC", 1900.0),
                new Order("PC", 2900.0),
                new Order("Headphones", 300.0)
        );

        Map<String, Double> topProducts =
                orders.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Order::product,
                                        Collectors.summingDouble(
                                                Order::cost
                                        )
                                )
                        )
                        .entrySet()
                        .stream()
                        .sorted(
                                Map.Entry.<String, Double>
                                                comparingByValue()
                                        .reversed()
                        )
                        .limit(3)
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (a, b) -> a,
                                        LinkedHashMap::new
                                )
                        );

        System.out.println(topProducts);
    }
}
