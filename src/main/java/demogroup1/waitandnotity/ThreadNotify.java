package demogroup1.waitandnotity;

/**
 * Created by sc on 2019-03-29.
 */
public class ThreadNotify extends Thread{

    private Object lock;

    public ThreadNotify(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("开始执行 thread notify");
            lock.notify();
            System.out.println("结束执行 thread notify");
        }
    }
}
