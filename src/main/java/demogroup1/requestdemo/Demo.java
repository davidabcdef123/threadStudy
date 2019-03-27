package demogroup1.requestdemo;

/**
 * Created by sc on 2019-03-27.
 * 这种实现方式类似于zookeeper利用多线程+阻塞队列的形式实现对异步化请求的处理，提升性能
 */
public class Demo {

    PrintProcessor printProcessor;

    public Demo(){
        SaveProcessor saveProcessor=new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("hello");
        new Demo().doTest(request);

    }

    public void doTest(Request request){
        printProcessor.processorRequest(request);
    }
}
