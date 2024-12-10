package lab_5;

import java.util.concurrent.*;

public class CallableClass implements Callable<String> {
    
    private final ComandaOnlineClass comandaOnline;

    public CallableClass(ComandaOnlineClass comandaOnline) {
        this.comandaOnline = comandaOnline;
    }

 
    public String call() throws Exception {
        System.out.println("Procesare cu Callable: " + Thread.currentThread().getName() + ", " + comandaOnline);
        return "Comanda " + comandaOnline + " s-a procesat";
    }
}
