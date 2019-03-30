package demogroup1.locldemo;

/**
 * Created by sc on 2019-03-30.
 */
public class Test {

    private volatile int a;

    public Test(int a) {
        int b=1;
        int c=2;
        int d=3;
        this.a = a;
        int e=4;
        int f=5;
        int g=6;
    }

    public static void main(String[] args) {
        Test t1 = new Test(1);
    }
}
