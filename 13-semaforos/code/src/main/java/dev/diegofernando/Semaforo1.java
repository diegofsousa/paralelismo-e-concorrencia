package dev.diegofernando;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Semaforo1 {

    private static final Semaphore SEMAFORO = new Semaphore(3);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {
            String name = Thread.currentThread().getName();
            int usuario = new Random().nextInt(10000);

            acquire();
            System.out.println("Usuário " + usuario + " se inscreveu usando a thread " + name + "\n");
            sleep();
            SEMAFORO.release();
        };

        for (int i = 0; i < 500; i++) {
            executor.execute(r1);
        }

        executor.shutdown();

    }

    private static void acquire() {
        try {
            SEMAFORO.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sleep() {
        try {
            int tempoEspera = new Random().nextInt(6);
            tempoEspera++;
            Thread.sleep(1000 * tempoEspera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
