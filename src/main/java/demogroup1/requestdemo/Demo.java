package demogroup1.requestdemo;

/**
 * Created by sc on 2019-03-27.
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
