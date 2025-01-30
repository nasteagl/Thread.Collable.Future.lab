package lab_5;


import java.util.*;
import java.util.concurrent.*;

public class MainClass {
public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    List<ComandaOnlineClass> comenzi = Collections.synchronizedList(new ArrayList<>());

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 1* 30 * 1000;


        
        Runnable addCommandTask = () -> {
            int maxComenzi=6;
            int comenziAddd=0;
            while (comenziAddd < maxComenzi && System.currentTimeMillis() < endTime) {
                ComandaOnlineClass comanda = new ComandaOnlineClass();
                comenzi.add(comanda);
                comenziAddd++;
                System.out.println("Comanda adaugata: " + comanda);

                
                ThreadClass thread = new ThreadClass(comanda);
                thread.start();

                
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Timpul a expirat. Se inchid procesul de adaugare a comenzilor.");
        };

       
        executorService.submit(addCommandTask);

       
        Callable<Void> processCommandsTask = () -> {
            synchronized (comenzi) {
                for (ComandaOnlineClass comanda : comenzi) {
                    System.out.println("Procesam comanda: " + comanda);
                    CallableClass callable = new CallableClass(comanda);
                    FutureTask<String> futureTask = new FutureTask<>(callable);
                    executorService.submit(futureTask);

                    try {
                       
                        String rezultat = futureTask.get();
                        System.out.println("Comanda procesata: " + rezultat);
                    } catch (InterruptedException | ExecutionException e) {
                        System.err.println("Eroare la procesarea comenzii: " + e.getMessage());
                    }
                }
            }
            return null;
        };
        executorService.submit(() -> {
            try {
                Thread.sleep(1 * 60 * 1000); 
                System.out.println("Incepem procesarea tuturor comenzilor.");
                processCommandsTask.call();
                comenzi.clear(); 
                System.out.println("Toate comenzile au fost procesate si lista a fost golita.");
            } catch (Exception e) {
                System.out.println("Eroare la procesarea comenzilor: " + e.getMessage());
            } 
        });

        try {
            if (!executorService.awaitTermination(2, TimeUnit.MINUTES)) {
                executorService.shutdownNow(); 
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow(); 
        }
        
      executorService.shutdown();
}
}



