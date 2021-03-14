package dev.diegofernando;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

public class ReentrantLock {

    private static int i = -1;

    private static Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {
            lock.lock(); // com lock podemos fazer lock em um lugar e fazer unlock em outro completamente diferente.
            String name = Thread.currentThread().getName();
            i++;
            System.out.println(name + " : " + i);
            lock.unlock();
        };

        for (int j = 0; j < 6; j++) {
            executor.execute(r1);
        }

        executor.shutdown();
    }

}
