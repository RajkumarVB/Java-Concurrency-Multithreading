package threads3;

import java.util.Scanner;
import java.util.concurrent.*;

public class C_WithDifferentExecutors {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService =(ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
        Runnable statusReporterRunnable = () -> {
            System.out.println("Running report");
            System.out.println("Active threads: " + executorService.getActiveCount());
            System.out.println("Completed threads: " + executorService.getCompletedTaskCount());
        };
        scheduledExecutor.scheduleAtFixedRate(statusReporterRunnable,1,5, TimeUnit.SECONDS);
//        ExecutorService executorService =(ThreadPoolExecutor) Executors.newCachedThreadPool();


        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the input : ");
            int input = sc.nextInt();
            if(input ==0) break;
            Runnable r = () -> {
                int result = calculateNthPrimeNumber(input);
                System.out.println("Output -----------");
                System.out.println(input + "th Prime number is :" + result);
            };
            executorService.execute(r);
        }
    }
    static int calculateNthPrimeNumber(int number){
        if (number ==1) return 2;
        int resultPrimeNumber = 2;
        int noOfPrimesFound = 1;
        for(int i=3;i<Integer.MAX_VALUE;i++){
            if(noOfPrimesFound == number) return resultPrimeNumber;
            boolean isPrimeNumber = true;
            for (int j = 2; j <i; j++) {
                if(i %j ==0){
                    isPrimeNumber = false;
                    break;
                }
            }
            if(isPrimeNumber){
                resultPrimeNumber = i ;
                noOfPrimesFound++;
            }
        }
        return resultPrimeNumber;
    }
}