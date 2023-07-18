package threads4;

import java.util.concurrent.ForkJoinPool;

public class PrimeNumberSumWithForkJoin {

    public void runForkJoinExample(){
        int [] inputNumbers ={2,3,4,5,6,7,8,9,10};
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        CalculatePrimeTask calculatePrimeTask = new CalculatePrimeTask(inputNumbers, 0, inputNumbers.length - 1);
        Integer result = forkJoinPool.invoke(calculatePrimeTask);
        System.out.println("Result : " + result);
    }
    public static void main(String[] args) {
        new PrimeNumberSumWithForkJoin().runForkJoinExample();
    }
}
