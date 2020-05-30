package com.example.test;

import reactor.core.publisher.Flux;

public class TestReactive {
    public static void main(String[] args) {
        // just直接声明
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        flux.subscribe(System.out::println);
    }
    
}
