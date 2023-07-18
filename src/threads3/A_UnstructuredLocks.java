package threads3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter implements Runnable{
    private int value = 0 ;
    Lock l = new ReentrantLock();
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
        l.lock();
        try{
            this.increment();
            System.out.println(Thread.currentThread().getName() + " increments : " + this.getValue());
            this.decrement();
            System.out.println(Thread.currentThread().getName() + " decrements : " + this.getValue());
        } finally {
            l.unlock();
        }
    }
    public int getValue() {
        return value;
    }
}
public class A_UnstructuredLocks {
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
