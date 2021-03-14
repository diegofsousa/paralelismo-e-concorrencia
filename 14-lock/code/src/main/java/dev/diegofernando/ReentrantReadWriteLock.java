package dev.diegofernando;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ReentrantReadWriteLock {
    private static int i = -1;

    private static ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // um lock de leitura não bloqueia um outro lock de leitura
        // já um lock de escrita bloqueia

        Runnable r1 = () -> {
            Lock writeLock = lock.writeLock();// com lock podemos fazer lock em um lugar e fazer unlock em outro completamente diferente.
            writeLock.lock();
            String name = Thread.currentThread().getName();
            System.out.println("Escrevendo: " + i);
            i++;
            System.out.println("Escrito: " + i);
            writeLock.unlock();
        };

        Runnable r2 = () -> {
            Lock readLock = lock.readLock();// com lock podemos fazer lock em um lugar e fazer unlock em outro completamente diferente.
            readLock.lock();
            String name = Thread.currentThread().getName();
            System.out.println("Lendo: " + i);
            System.out.println("Lido: " + i);
            readLock.unlock();
        };

        for (int j = 0; j < 6; j++) {
            executor.execute(r1);
            executor.execute(r2);
        }

        executor.shutdown();
    }
}
