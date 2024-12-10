package lab_5;
public class ThreadClass extends  Thread{
     private final ComandaOnlineClass comandaOnline;

     public ThreadClass(ComandaOnlineClass comandaOnline){
        this.comandaOnline=comandaOnline;
     }

     public void run(){
        System.out.println("Threadul "+currentThread().getName() + " ,proceseaza comanda: "+comandaOnline);
        System.out.println("----------------------------------------------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Threadul s-a intrerupt:"+e.getMessage());
            Thread.currentThread().interrupt();
        }
     }
}
