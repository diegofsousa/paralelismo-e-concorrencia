package dev.diegofernando;

public class Threads_1 {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // Captura de uma thread em execução
        System.out.println(t.getName()); // Nome da thread. retorna "main" pois é a thread principal.

        //Nova thread - forma mais simples
        MeuRunnable meuRunnable = new MeuRunnable();
        Thread t1 = new Thread(meuRunnable);
        // t1.run(); isso aqui não cria thread, só executa na mesma que foi chamada

        // Runnable como lambda
        Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        // t2.start(); uma thread não pode ser iniciada mais de uma vez

        // várias threads
        Thread t3 = new Thread(meuRunnable);


        t1.start(); // "inicie esta thread do jeito que vocẽ quiser JVM, assim que possível"
        t2.start();
        t3.start();
    }
}
