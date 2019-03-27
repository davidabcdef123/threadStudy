package demogroup1;

import java.util.concurrent.TimeUnit;

/**
 * Created by sc on 2019-03-27.
 * 1 jsp命令查看java进程
 * 2 jstack pid 查看线程状态
 */
public class ThreadStatusDemo {

    public static void main(String[] args) {
        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"timewaiting").start();
        //类锁会锁定这个类锁创建的所有对象，而对象锁只能锁住当前对象
        new Thread(()->{
           while (true){
               synchronized (ThreadStatusDemo.class){
                   try {
                       ThreadStatusDemo.class.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        },"waiting").start();

        new Thread(new BlockDemo(),"blockDemo-0").start();
        new Thread(new BlockDemo(),"blockDemo-1").start();

    }

    static class BlockDemo extends Thread{

        @Override
        public void run(){
            synchronized (BlockDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
