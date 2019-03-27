package demogroup1.requestdemo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sc on 2019-03-27.
 * Processor 处理器
 * process 进程
 */
public class PrintProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<>();

    private final RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor){
        this.nextProcessor=nextProcessor;
    }

    @Override
    public void run() {
        System.out.println("我是PrintProcessor");
        while (true){
            try {
                int a=0;
                Request request=linkedBlockingQueue.take();
                System.out.println("PrintProcessor print data:" + request);
                nextProcessor.processorRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }
}
