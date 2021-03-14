package dev.diegofernando;

import java.util.concurrent.*;

public class CyclicBarrier3 {
    // Situação alvo: várias threads executando ao mesmo tempo.. e em algum momento uma deve esperar pela outra.
    // 432*3 + 3^14 + 45*127/12 = ? - cada thread faz um pedaço da operação
    // Um 'd' no final do numero o transforma em double.

    private static BlockingQueue<Double> resultados = new LinkedBlockingQueue<>(); //Armazenando
    private static ExecutorService executor;
    private static Runnable r1;
    private static Runnable r2;
    private static Runnable r3;
    private static double resultadoFinal = 0;

    public static void main(String[] args) {
        Runnable sumarizacao = () -> {
            System.out.println("Somando tudo");
            resultadoFinal += resultados.poll();
            resultadoFinal += resultados.poll();
            resultadoFinal += resultados.poll();
            System.out.println("Processamento finalizado. " +
                    "Resultado final: " + resultadoFinal);
            System.out.println("--------------");
            restart();

        };

        // o sumarizacao.run() é chamado pelo próprio CyclicBarrier

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, sumarizacao); // 3 é a quantidade de participantes da barreira. É um ponto de sincronia entre multiplas execuções.

        executor = Executors.newFixedThreadPool(3);

        r1 = () -> {
            while (true) {
                resultados.add(432d * 3d);
                await(cyclicBarrier);
                sleep();
            }
        };

        r2 = () -> {
            while (true) {
                resultados.add(Math.pow(3, 14));
                await(cyclicBarrier);
                sleep();
            }
        };

        r3 = () -> {
            while (true) {
                resultados.add(45d * 127d / 12d);
                await(cyclicBarrier);
                sleep();
            }
        };

        restart();


//        executor.shutdown();
    }

    private static void await(CyclicBarrier cyclicBarrier){
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
    private static void restart(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.submit(r1);
        executor.submit(r2);
        executor.submit(r3);
    }

    private static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
