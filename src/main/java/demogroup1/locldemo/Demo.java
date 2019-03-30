package demogroup1.locldemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sc on 2019-03-29.
 */
public class Demo {


    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        ThreadWait threadWait = new ThreadWait(lock,condition);
        threadWait.start();
        ThreadNotify threadNotify = new ThreadNotify(lock,condition);
        threadNotify.start();
    }
}
