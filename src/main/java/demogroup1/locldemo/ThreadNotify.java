package demogroup1.locldemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by sc on 2019-03-29.
 */
public class ThreadNotify extends Thread{

    private Lock lock;
    private Condition condition;

    public ThreadNotify(Lock lock,Condition condition) {
        this.lock = lock;
        this.condition=condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("开始执行 thread notify");
            condition.signal(); //相当于notify
            System.out.println("结束执行 thread notify");
        } finally {
            lock.unlock();
        }
    }
}
