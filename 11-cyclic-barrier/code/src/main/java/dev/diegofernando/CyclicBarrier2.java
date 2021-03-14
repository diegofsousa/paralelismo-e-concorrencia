package dev.diegofernando;

import java.util.concurrent.*;

public class CyclicBarrier2 {
    // Situação alvo: várias threads executando ao mesmo tempo.. e em algum momento uma deve esperar pela outra.
    // 432*3 + 3^14 + 45*127/12 = ? - cada thread faz um pedaço da operação
    // Um 'd' no final do numero o transforma em double.

    private static BlockingQueue<Double> resultados = new LinkedBlockingQueue<>(); //Armazenando

    public static void main(String[] args) {
        Runnable finalizacao = () -> {
            System.out.println("Somando tudo. ");
            double resultadoFinal = 0;
            resultadoFinal += resultados.poll();
            resultadoFinal += resultados.poll();
            resultadoFinal += resultados.poll();
            System.out.println("Processamento finalizado. " +
                    "Resultado final: " + resultadoFinal);

        };

        // o finalizacao.run() é chamado pelo próprio CyclicBarrier

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, finalizacao); // 3 é a quantidade de participantes da barreira. É um ponto de sincronia entre multiplas execuções.

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable r1 = () -> {
            resultados.add(432d*3d);
            System.out.println(432d*3d);
            await(cyclicBarrier);
            System.out.println("Terminei o processamento.");
        };

        Runnable r2 = () -> {
            resultados.add(Math.pow(3, 14));
            System.out.println(Math.pow(3, 14));
            await(cyclicBarrier);
            System.out.println("Terminei o processamento.");
        };

        Runnable r3 = () -> {
            resultados.add(45d*127d/12d);
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
