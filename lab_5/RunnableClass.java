package lab_5;
public class RunnableClass implements Runnable {
    private final ComandaOnlineClass comandaOnline;

    public RunnableClass( ComandaOnlineClass comandaOnline){
        this.comandaOnline =comandaOnline;

    }
    public void run(){
        System.out.println("Runnable: Procesare comanda - " + comandaOnline);
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread întrerupt: " + e.getMessage());
        }
    }
    }




//sheduule_thread 
