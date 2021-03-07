package dev.diegofernando;

import java.util.Random;
import java.util.concurrent.*;

public class ExcutoresSingleThreadComCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = null;
        try {
            executor = Executors.newSingleThreadExecutor(); // nova thread

            Future<String> future = executor.submit(new Tarefa());

            System.out.println(future.isDone());
//            System.out.println(future.get()); // O get espera o callable ser chamado para mostrar o valor. Por isso o isDone depois do get sempre mostrará true.
            System.out.println(future.get(3, TimeUnit.SECONDS)); // [RECOMENDADO] Podemos adicionr um timeout ao get que retorna uma exception caso não seja retornado em tempo definido.
            System.out.println(future.isDone());

//            executor.shutdown();
//            executor.awaitTermination(10, TimeUnit.SECONDS);
//            System.out.println(future.isDone());
        } catch (Exception e){
            throw e;
        } finally {
            if(executor != null){
//                executor.shutdown();
                executor.shutdownNow();
            }
        }


    }

    public static class Tarefa implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            String name = Thread.currentThread().getName();
            int nextInt = new Random().nextInt(1000);
            return "Diego Fernando rodando na thread " + name + " com numero aleatório " + nextInt;
        }
    }
}
