package demogroup1.waitandnotity;

/**
 * Created by sc on 2019-03-29.
 */
public class Demo {

    public static void main(String[] args) {
        Object lock=new Object();
        ThreadWait threadWait = new ThreadWait(lock);
        threadWait.start();
        ThreadNotify threadNotify = new ThreadNotify(lock);
        threadNotify.start();
    }
}
