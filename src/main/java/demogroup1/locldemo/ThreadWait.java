package demogroup1.locldemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by sc on 2019-03-29.
 */
public class ThreadWait extends Thread {

    private Lock lock;
    private Condition condition;

    public ThreadWait(Lock lock,Condition condition){
        this.lock=lock;
        this.condition=condition;
    }

    @Override
    public void run() {
        lock.lock();
         System.out.println("开始执行 thread wait");
         try {
             condition.await();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }finally {
             lock.unlock();
         }
         System.out.println("执行结果 thread wait ");
    }
}
