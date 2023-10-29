package org.example.task3;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        RaceAsync raceAsync = new RaceAsync(new Runner(8000,"Runner1"),
                                            new Runner(5000,"Runner2"),
                                            new Runner(2000,"Runner3"));
        raceAsync.start();
    }
}
