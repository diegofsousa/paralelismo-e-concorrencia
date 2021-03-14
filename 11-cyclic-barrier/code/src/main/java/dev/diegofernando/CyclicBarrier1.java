package dev.diegofernando;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrier1 {
    // Situação alvo: várias threads executando ao mesmo tempo.. e em algum momento uma deve esperar pela outra.
    // 432*3 + 3^14 + 45*127/12 = ? - cada thread faz um pedaço da operação
    // Um 'd' no final do numero o transforma em double.
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3); // 3 é a quantidade de participantes da barreira. É um ponto de sincronia entre multiplas execuções.

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable r1 = () -> {
            System.out.println(432d*3d);
            await(cyclicBarrier);
            System.out.println("Terminei o processamento.");
        };

        Runnable r2 = () -> {
            System.out.println(Math.pow(3, 14));
            await(cyclicBarrier);
            System.out.println("Terminei o processamento.");
        };

        Runnable r3 = () -> {
            System.out.println(45d*127d/12d);
            await(cyclicBarrier);
            System.out.println("Terminei o processamento.");
        };

        executor.submit(r1);
        executor.submit(r2);
        executor.submit(r3);

        executor.shutdown();
    }

    private static void await(CyclicBarrier cyclicBarrier){
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
