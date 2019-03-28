package demogroup1;

/**
 * Created by sc on 2019-03-28.
 * javap -c
 */
public class VolatileDemo {

    private static int  x=0,y=0;
    private static int a=0,b=0;

    //DLC(Double Check Lock)
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            a=1;
            x=b;
        });
        Thread t2 = new Thread(()->{
            b=1;
            y=a;
        });
        t1.start();
        t2.start();
        t1.join();//底层是wait->notify
        t2.join();//相当于callback等待执行结束
        System.out.println("x="+x);
        System.out.println("y="+y);
        //[x=0,y=1]t1先执行完，然后t2执行
        //[x=1 y=0]t2先执行完，然后t1执行
        //交替执行[x=1,y=1]
        //极端情况下当指令集重拍 x=b在a-1的前边，并且y=a在b=1的前边，然后交替执行t1和t2会导致[x=0,y=0]

    }
}
