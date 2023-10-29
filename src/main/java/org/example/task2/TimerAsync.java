package org.example.task2;
//Создайте два потока A и B.
//        Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд
//        (true в состояние false и наоборот).
//        Поток B ожидает состояния true переменной switcher и выводит на консоль обратный
//        отсчет от 100 с задержкой 100 миллисекунд и приостанавливает свое действие, как
//        только поток A переключит switcher в состояние false.
//        Условием завершения работы потоков является достижение отсчета нулевой отметки.

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerAsync {
    AtomicBoolean isRunning = new AtomicBoolean(false);
    AtomicInteger timeout = new AtomicInteger(100);


    public void run() {
        Thread current = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    isRunning.set(!isRunning.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread counterThread = new Thread(() -> {
            while (timeout.get() > 0) {
                if (isRunning.get()) {
                    while (isRunning.get()) {
                        try {
                            Thread.sleep(100);
                            timeout.set(timeout.get() - 1);
                            System.out.println("Timeout: " + timeout.get());
                            if (timeout.get() == 0) {
//                                current.interrupt();
                                break;
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        current.setDaemon(true);
        current.start();
        counterThread.start();
    }
}
