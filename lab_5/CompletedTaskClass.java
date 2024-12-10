package lab_5;
import java.util.concurrent.*;
public class CompletedTaskClass  {
public static void printCompletedTask(FutureClass futureClass){
    try {
        String res=futureClass.getFutureTask().get();
        System.out.println("Task complet:"+res);
    } catch(InterruptedException | ExecutionException e) {
        System.out.println("Eroare la obtinerea rezultatului"+e.getMessage());
    }
}
}
