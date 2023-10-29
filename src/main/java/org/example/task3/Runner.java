package org.example.task3;
public class Runner extends Thread {
    private int delay;

    public Runner( int delay, String  name) {
        super(name);
        this.delay = delay;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ", ready for start");
        RaceAsync.latchStart.countDown();
        try {
            RaceAsync.latchStart.await();
            Thread.sleep(delay);
            RaceAsync.countFinished.set(RaceAsync.countFinished.get() - 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ", is finished!");
    }

}
