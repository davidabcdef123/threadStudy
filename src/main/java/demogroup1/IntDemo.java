package demogroup1;

import java.lang.reflect.Field;

/**
 * @author: sun chao
 * Create at: 2019-06-30
 */
public class IntDemo {

    public static void main(String[] args) throws Exception {
        Integer a=1,b=2;
        System.out.println("before a="+a+",b="+b);
        swap(a,b);
        System.out.println("after a="+a+",b="+b);
    }

    private static void swap(Integer a, Integer b) throws Exception {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        int temp=a.intValue();
        System.out.println("temp="+temp);
        //integer.valueof()是走缓存的
        field.set(a, b.intValue());//a->Integer.valueOf(b.intValue()).initvalue()
        field.set(b,temp);
    }
}
