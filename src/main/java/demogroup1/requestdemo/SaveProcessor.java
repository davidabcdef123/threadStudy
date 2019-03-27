package demogroup1.requestdemo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sc on 2019-03-27.
 */
public class SaveProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        System.out.println("我是SaveProcessor");
        while (true){
            try {
                int a=0;
                Request request=linkedBlockingQueue.take();
                System.out.println("SaveProcessor save data:"+request);
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
