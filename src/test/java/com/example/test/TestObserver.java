package com.example.test;

import java.util.Observable;

/**
 * java8的观察者
 */
public class TestObserver extends Observable {
    

    public static void main(String[] args) {
        TestObserver testObserver = new TestObserver();
        
        testObserver.addObserver((o, arg) -> {
            System.out.println("发生了变化");
        });

        testObserver.addObserver((o, arg) -> {
            System.out.println("数据发生了变化");
        });
        
        testObserver.setChanged();
        testObserver.notifyObservers();
    }
}
