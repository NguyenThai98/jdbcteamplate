package com.example.demo;

import reactor.core.publisher.Mono;

public class testFunc {
    public static void main(String[] args) {
        Mono<Integer> integerMono =  Mono.just(10);
        System.out.println(integerMono.block());
        System.out.println(12);
    }
}
