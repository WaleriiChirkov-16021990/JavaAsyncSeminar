package org.example.task1;

import org.example.task1.GeneralClass;
import org.example.task1.GeneralClass2;
import org.example.task1.ObjectA;
import org.example.task1.ObjectB;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        Thread a = new Thread(new ObjectA());
//        Thread b = new Thread(new ObjectB());
//        a.start();
//        b.start();
//        a.interrupt();
//        b.interrupt();
        ObjectB objectB = new ObjectB();
        ObjectA objectA = new ObjectA();
        GeneralClass g = new GeneralClass(objectA,objectB);
        GeneralClass2 g2 = new GeneralClass2(objectA,objectB);
        g.start();
        g2.start();
    }
}