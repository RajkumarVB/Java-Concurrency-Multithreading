package threads3;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class B_PrimeNumberWithThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the input : ");
            int input = sc.nextInt();
            if(input ==0) break;
            Runnable r = () -> {
                int result = util.PrimeNumberUtil.calculateNthPrimeNumber(input);
                System.out.println("Output -----------");
                System.out.println(input + "th Prime number is :" + result);
            };
            executorService.execute(r);
        }
    }
}