package threads3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class F_PrimeNumberWithCallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the input : ");
            int input = sc.nextInt();
            if(input ==0) break;
//            Callable<Integer> c = new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    return calculateNthPrimeNumber(input);
//                }
//            };
            Callable<Integer> c = () -> {
                return util.PrimeNumberUtil.calculateNthPrimeNumber(input);
            };
            Future<Integer> primeNumberFuture = executorService.submit(c);
            futures.add(primeNumberFuture);
        }
        Iterator<Future<Integer>> it = futures.iterator();
        while(it.hasNext()){
            Future<Integer> f= it.next();
            if(f.isDone()){
                System.out.println(f.get());
                it.remove();
            }
        }
        executorService.shutdown();
    }
}
