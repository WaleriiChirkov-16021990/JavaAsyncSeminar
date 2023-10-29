package org.example.task1;

public class GeneralClass extends Thread {

    private ObjectA objectA;
    private ObjectB objectB;

    public GeneralClass(ObjectA objectA, ObjectB objectB) {
        this.objectA = objectA;
        this.objectB = objectB;
    }

    public void run() {
        synchronized (objectA) {
            System.out.println("GeneralClass started and is holding objectA");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("GeneralClass is waiting for objectB");
            synchronized (objectB) {
                System.out.println("GeneralClass is holding objectA and objectB");
            }
        }
//        Thread newThread = new Thread(() -> {
//            while (true) {

//                synchronized (objectB) {
//                    System.out.println("New Thread started and is holding ObjectB");
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("New Thread is waiting for ObjectA");
//                    synchronized (objectA) {
//                        System.out.println("New Thread is holding ObjectA and ObjectB");
//                    }
//                }
            }
//        });
//        newThread.setDaemon(true);
//        newThread.start();
//    }
}
