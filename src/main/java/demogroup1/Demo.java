package demogroup1;

/**
 * Created by sc on 2019-03-28.
 */
public class Demo {

    private static int count=0;

    public synchronized static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                incr();
            }).start();
        }
        Thread.sleep(4000);
        System.out.println(count);
    }
}
