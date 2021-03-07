package dev.diegofernando;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.*;

public class SchedulerExecutors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
//        executor.schedule(new Tarefa(), 2, TimeUnit.SECONDS);
//        executor.scheduleAtFixedRate(new Tarefa(), 0, 1, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(new Tarefa(), 0, 1, TimeUnit.SECONDS);

//        executor.shutdown();

    }
    public static class Tarefa implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalTime.now());
            String name = Thread.currentThread().getName();
            int nextInt = new Random().nextInt(1000);
            System.out.println("Diego Fernando rodando na thread " + name + " com numero aleatório " + nextInt);
        }
    }
}
