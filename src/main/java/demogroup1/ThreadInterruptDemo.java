package demogroup1;

import java.util.concurrent.TimeUnit;

/**
 * Created by sc on 2019-03-27.
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println("aaaaaaa");
            while (true){
                boolean in=Thread.currentThread().isInterrupted();
                if(in){
                    System.out.println("before:"+in);
                    Thread.interrupted();//复位
                    System.out.println("after:"+Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();//中断
    }
}
