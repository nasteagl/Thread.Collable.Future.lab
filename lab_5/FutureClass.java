package lab_5;
import java.util.concurrent.*;
public class FutureClass {
    private final CallableClass callableClass;
    private final FutureTask<String> futureTask;

    public FutureClass(CallableClass callableClass){
        this.callableClass=callableClass;
        this.futureTask=new FutureTask<>(callableClass);
    }

    public Future<String>getFutureTask(){
        return futureTask;
    }

}
