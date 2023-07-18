package threads3;

import java.util.concurrent.*;

public class E_FutureObject {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("In callable");
                Thread.sleep(2000);
                return "From Callable";
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> returnedValue = executorService.submit(c);
        System.out.println("In main thread");
        System.out.println("In main thread");
        System.out.println(returnedValue.get());
    }
}