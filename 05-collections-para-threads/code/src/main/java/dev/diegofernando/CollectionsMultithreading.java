package dev.diegofernando;

import java.util.*;
import java.util.concurrent.*;

public class CollectionsMultithreading {
    private static List<String> lista = new CopyOnWriteArrayList<>(); // Sempre que fazemos uma operação ele faz uma cópia dele mesmo. Pouca performance.
    private static Map<Integer, String> mapa = new ConcurrentHashMap<>(); // Solução thread-safe para mapas
    private static BlockingQueue<String> fila = new LinkedBlockingQueue<>(); // Solução thread-safe para filas, new LinkedBlockingQueue<>(2); também pode ser possível limitar

    // LinkedBlockingDeque é uma fila que pode ser manuseada dos dois lados.

    public static void main(String[] args) throws InterruptedException {
        // Coleções que são thread-safe (geralmente, classes desse tipo são mais pesadas).

        MeuRunnable runnable = new MeuRunnable();
        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();
        Thread.sleep(500);
//        System.out.println(lista);
        System.out.println(fila);
    }

    public static class MeuRunnable implements Runnable {

        @Override
        public void run() {
//            lista.add("Diego Fernando");
//            mapa.put(new Random().nextInt(), "Diego Fernando");
            fila.add("Diego Fernando");
            String name = Thread.currentThread().getName();
            System.out.println(name + " inseriu no mapa!");
        }
    }
}
