package demogroup1.waitandnotity;

/**
 * Created by sc on 2019-03-29.
 */
public class ThreadWait extends Thread {

    private Object lock;

    public ThreadWait(Object lock){
        this.lock=lock;
    }

    @Override
    public void run() {
     synchronized (lock){
         System.out.println("开始执行 thread wait");
         try {
             lock.wait();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("执行结果 thread wait ");
     }
    }
}
