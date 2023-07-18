package threads1;

class MyThread1 extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi");
        }
    }
}
class MyThread2 extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello");
        }
    }
}
public class ThreadsAlternateSyntax4 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        t1.start();
        t2.start();
    }
}
