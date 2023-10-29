package org.example.task1;

public class ObjectA implements Runnable {

    public ObjectA() {
    }

    @Override
    public void run() {
        System.out.println("ObjectA");
    }
}
