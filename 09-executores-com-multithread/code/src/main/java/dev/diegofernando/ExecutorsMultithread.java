package dev.diegofernando;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorsMultithread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = null;

        try {
//            executor = Executors.newFixedThreadPool(2); //Quantidade fxa de threads
            executor = Executors.newCachedThreadPool(); //Sempre que precisar crie uma thread nova, ou recicla uma thread

            List<Tarefa> lista = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                lista.add(new Tarefa());
            }

            List<Future<String>> list = executor.invokeAll(lista);

            for (Future<String> future : list){
                System.out.println(future.get());
            }

//            Future<String> f1 = executor.submit(new Tarefa());
//            Future<String> f2 = executor.submit(new Tarefa());
//            Future<String> f3 = executor.submit(new Tarefa());
//
//            System.out.println(f1.get());
//            System.out.println(f2.get());
//            System.out.println(f3.get());
            executor.shutdown();
        } catch (Exception e){
            throw e;
        } finally {
            if (executor != null){
                executor.shutdownNow();
            }
        }

    }

    public static class Tarefa implements Callable<String> {

        @Override
        public String call() throws Exception {
            String name = Thread.currentThread().getName();
            int nextInt = new Random().nextInt(1000);
            return "Diego Fernando rodando na thread " + name + " com numero aleatório " + nextInt;
        }
    }
}
