package demogroup1;

import java.util.concurrent.TimeUnit;

/**
 * Created by sc on 2019-03-27.
 *
 *
 */
public class VisableDemo {

    //无法保证可见性，所以有的时候进程会无法停止
    //private static boolean stop=false;

    //能保证线程的可见性
    private volatile static boolean stop=false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
           int i=0;
           while (!stop){
               i++;
           }
            System.out.println(i);
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        stop=true;
    }
}
