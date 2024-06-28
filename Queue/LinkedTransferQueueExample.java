package Com.Queue;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueExample {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        Thread producer = new Thread(() -> {
            try {
                queue.transfer("Element1");
                System.out.println("Produced: Element1");
                Thread.sleep(1000);
                queue.transfer("Element2");
                System.out.println("Produced: Element2");
                Thread.sleep(1000);
                queue.transfer("Element3");
                System.out.println("Produced: Element3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();

        Thread consumer = new Thread(() -> {
            try {
                String element = queue.take();
                System.out.println("Consumed: " + element);
                element = queue.take();
                System.out.println("Consumed: " + element);
                element = queue.take();
                System.out.println("Consumed: " + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumer.start();

        producer.join();
        consumer.join();
    }
}