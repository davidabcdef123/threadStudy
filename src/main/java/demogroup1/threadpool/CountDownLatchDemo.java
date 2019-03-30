package demogroup1.threadpool;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sc on 2019-03-30.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->{
            /*try {
                Thread.sleep(2000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            countDownLatch.countDown();  //递减

        }).start();

        new Thread(()->{
            /*try {
                Thread.sleep(2000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            countDownLatch.countDown();

        }).start();

        new Thread(()->{
            countDownLatch.countDown();
           /* try {
                Thread.sleep(2000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }).start();

        countDownLatch.await();
        System.out.println("执行完毕 ");

    }
}
