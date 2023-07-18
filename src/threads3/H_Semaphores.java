package threads3;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class H_Semaphores {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
//        Semaphore semaphore = new Semaphore(3,true);
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the input : ");
            int input = sc.nextInt();
            if(input ==0) break;
            Runnable r = () -> {
//                semaphore.acquire(2);
                try {
                    semaphore.acquire();
                    int result = util.PrimeNumberUtil.calculateNthPrimeNumber(input);
                    System.out.println("Output -----------");
                    System.out.println(input + "th Prime number is :" + result);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted while acquiring");
                } finally {
                    semaphore.release();
                }
            };
            Thread t1 = new Thread(r);
            t1.start();
        }
    }
}