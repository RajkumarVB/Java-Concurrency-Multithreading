package util;

public class PrimeNumberUtil {
    public static int calculateNthPrimeNumber(int number){
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
