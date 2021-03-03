package dev.diegofernando;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OperacoesAtomicas {
    static AtomicInteger i = new AtomicInteger(-1);
    //AtomicLong
    //AtomicFalse
    //AtomicReference

    public static void main(String[] args) throws InterruptedException {

        MeuRunnable runnable = new MeuRunnable();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();
        Thread.sleep(500);
    }

    public static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " : " + i.incrementAndGet());
        }
    }
}
