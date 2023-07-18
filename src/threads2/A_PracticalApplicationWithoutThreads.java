package threads2;

import java.util.Scanner;

public class A_PracticalApplicationWithoutThreads {
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the input : ");
            int input = sc.nextInt();
            if(input ==0) break;
            System.out.println(util.PrimeNumberUtil.calculateNthPrimeNumber(input));
        }
    }
}
