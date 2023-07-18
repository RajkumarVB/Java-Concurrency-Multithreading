package threads3;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class G_CompletableFutureObject {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the input : ");
            int input = sc.nextInt();
            if(input ==0) break;
            CompletableFuture.supplyAsync(()-> util.PrimeNumberUtil.calculateNthPrimeNumber(input),executorService).thenAccept(System.out::println);
//            CompletableFuture.supplyAsync(()-> calculateNthPrimeNumber(input)).thenAccept(System.out::println);
//            CompletableFuture.supplyAsync(()-> calculateNthPrimeNumber(input)).thenAccept((n)->{
//                System.out.println(n);
//            });
        }
    }
}
