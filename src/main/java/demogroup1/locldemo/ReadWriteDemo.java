package demogroup1.locldemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sc on 2019-03-30.
 */
public class ReadWriteDemo {

    static Map<String, Object> cacheMap = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock read=rwl.readLock();
    static Lock write=rwl.writeLock();

    public static final Object get(String key){
        System.out.println("开始读取数据");
        try {
            read.lock();//上读锁
            return cacheMap.get(key);
        } finally {
            read.lock();
        }
    }

    public static final Object put(String key,Object value){
        write.lock();
        System.out.println("开始写数据");
        try {
            return cacheMap.put(key, value);
        } finally {
            write.unlock();
        }
    }

}
