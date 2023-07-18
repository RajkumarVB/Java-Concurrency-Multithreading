package threads2;

import java.util.Scanner;

public class B_PracticalApplicationWithThreads {
    public static void main(String[] args) {
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
            t1.start();
        }
    }
}
