package com.example.test;

import java.util.concurrent.Flow;

/**
 * java9+对响应编程的封装
 */
public class TestFlow {
    public static void main(String[] args) {
        Flow.Publisher<String> publisher = subscriber -> {
            subscriber.onNext("1");
            subscriber.onNext("2");
            subscriber.onError(new RuntimeException("err!"));
            subscriber.onComplete();
        };
        
        publisher.subscribe(new Flow.Subscriber<String>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                subscription.cancel();
            }

            @Override
            public void onNext(String item) {
                System.out.println(item);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
