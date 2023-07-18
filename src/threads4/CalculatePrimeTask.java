package threads4;

import util.PrimeNumberUtil;

import java.util.concurrent.RecursiveTask;

public class CalculatePrimeTask extends RecursiveTask<Integer> {
    int[] array;
    int start ;
    int end ;

    public CalculatePrimeTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(start == end) {
            int result = PrimeNumberUtil.calculateNthPrimeNumber(array[start]);
            System.out.println("I'm here1 " + array[start] +" result : " + result);
            return result;
        }
        if(end - start == 1){
            int result = util.PrimeNumberUtil.calculateNthPrimeNumber(array[start])
                    + util.PrimeNumberUtil.calculateNthPrimeNumber(array[end]);
            System.out.println("I'm here2 " + array[start] + " " + array[end] + " result : " + result);

            return result;
        }
        int mid = (start + end) /2 ;
        CalculatePrimeTask subtask1 = new CalculatePrimeTask(array, start, mid);
        CalculatePrimeTask subtask2 = new CalculatePrimeTask(array, mid+1,end);
        invokeAll(subtask1,subtask2);
        return subtask1.join() + subtask2.join();
    }
}
