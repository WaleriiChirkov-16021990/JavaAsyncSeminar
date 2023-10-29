package org.example.task1;

public class GeneralClass2 extends Thread {

    private ObjectA objectA;
    private ObjectB objectB;

    public GeneralClass2(ObjectA objectA, ObjectB objectB) {
        this.objectA = objectA;
        this.objectB = objectB;
    }

    public void run() {
        synchronized (objectB) {
            System.out.println("New Thread started and is holding ObjectB");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("New Thread is waiting for ObjectA");
            synchronized (objectA) {
                System.out.println("New Thread is holding ObjectA and ObjectB");
            }
        }
    }
}
