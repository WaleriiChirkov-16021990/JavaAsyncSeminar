package org.example.task3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/*
3 бегуна должны прийти к старту гонки
Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
Программа должна отсчитать “На старт”, “Внимание”, “Марш”
Программа должна завершиться когда все участники закончат гонку.
 */
public class RaceAsync extends Thread{

    private Runner runner1; // 0 - not ready 1 - ready started 2 - running 3 - finished
    private Runner runner2;
    private Runner runner3;
    public static CountDownLatch latchStart = new CountDownLatch(6);
    public static AtomicInteger countFinished = new AtomicInteger(3);
//    private CountDownLatch latchFinish;

    public RaceAsync(Runner runner1, Runner runner2, Runner runner3) {
        this.runner1 = runner1;
        this.runner2 = runner2;
        this.runner3 = runner3;
    }

    public void run(){
        runner1.start();
        runner2.start();
        runner3.start();

        while (latchStart.getCount() > 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(500);
            System.out.println("На старт");
            Thread.sleep(500);
            latchStart.countDown();
            System.out.println("Внимание");
            Thread.sleep(500);
            latchStart.countDown();
            System.out.println("Марш");
            latchStart.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (countFinished.get() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
            System.out.println("All runners has finished! Race completed successfully");
    }
}
