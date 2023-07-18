package threads3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class D_Callable {
    public static void main(String[] args) {
        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "From Callable";
            }
        };
//        Callable<String> c = () -> "From Callable" ;
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(c);
    }
}