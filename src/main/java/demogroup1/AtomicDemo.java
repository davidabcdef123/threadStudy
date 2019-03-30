package demogroup1;

/**
 * Created by sc on 2019-03-27.
 * 运行结果会小于1000.原因 线程的可见性+原子性
 * 在子线程中的count不能及时同步到主内存中，导致1000个子线程中的count与主内存中的数据不一致，
 * 也就是说，工作内容中的数据与主内存中的不一致
 */
public class AtomicDemo {

    private static int couut=0;

    public   static void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        couut++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<1000;i++){
            //相当于匿名的实现了run方法，如果不调用start方法那么inc是不会真的运行的
            new Thread(AtomicDemo::inc).start();

        }
        Thread.sleep(4000);
        System.out.println("运行结果："+couut);
    }
}
