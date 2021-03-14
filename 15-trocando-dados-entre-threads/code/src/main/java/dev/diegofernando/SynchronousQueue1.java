package dev.diegofernando;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueue1 {

    private static final SynchronousQueue<String> FILA = new SynchronousQueue<>(); //Só conseguimos adicionar um elemento quando existe um para tirar

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable r1 = () -> {
            put();
            System.out.println("Escreveu na fila!");
        };

        Runnable r2 = () -> {
            String msg = take();
            System.out.println("Pegou da fila! " + msg);
        };

        executor.execute(r1);
        executor.execute(r2);
        executor.shutdown();
    }

    private static void put(){
        try {
            FILA.put("Inscreva-se");
//            FILA.offer(timeout, unit) // Para quando quisermos add limitadores de tempo para adicionar um elemento na fila
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    private static String take(){
        try {
            return FILA.take();
            // return FILA.pull(timeout, unit) // Para quando quisermos add limitadores de tempo para recuperar o elemento da fila
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return "Exceção";
        }

    }
}
