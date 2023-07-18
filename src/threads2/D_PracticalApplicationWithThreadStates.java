package threads2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D_PracticalApplicationWithThreadStates {
    public static void main(String[] args) {
        List<Thread> threadsSpawned = new ArrayList<>();

        Runnable statusReporter = () -> {
            try {
                while(true){
                    Thread.sleep(5000);
                    printThreadState(threadsSpawned);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };
        Thread statusReporterThread = new Thread(statusReporter);
        statusReporterThread.setDaemon(true);
        statusReporterThread.start();

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
            Thread t1 = new Thread(r);
            threadsSpawned.add(t1);
            t1.setDaemon(true);
            t1.start();
        }
    }

    private static void printThreadState(List<Thread> threadsSpawned) {
        System.out.print("\n Thread status: ");
        threadsSpawned.forEach(thread -> System.out.print(thread.getState() + " "));
    }
}
