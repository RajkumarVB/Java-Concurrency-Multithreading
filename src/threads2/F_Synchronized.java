package threads2;

class Counter implements Runnable{
    private int value = 0 ;
    private Integer i = 0 ;
    public void increment(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        this.value ++ ;
    }
    public void decrement(){
        this.value --;
    }

    @Override
    public void run(){
        synchronized (i){
//        synchronized (this){
            this.increment();
            System.out.println(Thread.currentThread().getName() + " increments : " + this.getValue());
            this.decrement();
            System.out.println(Thread.currentThread().getName() + " decrements : " + this.getValue());
        }
    }
    public int getValue() {
        return value;
    }
}
public class F_Synchronized {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(counter, "FirstThread").start();
        new Thread(counter, "SecondThread").start();
        new Thread(counter, "ThirdThread").start();
        new Thread(counter, "FourthThread").start();
        Counter counter2 = new Counter();
        new Thread(counter2,"secondCounterThread").start();
    }
}
