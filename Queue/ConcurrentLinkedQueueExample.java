package Com.Queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("Jalgaon");
        queue.add("Pune");
        queue.add("Mumbai");
        queue.add("Nashik");

        System.out.println("ConcurrentLinkedQueue: " + queue);

        queue.addAll(Arrays.asList("Gaurav", "Adarsh", "Vinay", "abhi", "Mahesh"));
        System.out.println("Collection added: " + queue.addAll(Arrays.asList("Gaurav", "Adarsh", "Vinay", "abhi", "Mahesh")));
        System.out.println("ConcurrentLinkedQueue: " + queue);

        queue.remove("Sanjeet");
        System.out.println("Removing Gaurav successful: " + queue.remove("Gaurav"));
        System.out.println("Updated ConcurrentLinkedQueue: " + queue);

        Iterator<String> iterator = queue.iterator();
        System.out.println("The String Values of iterator are: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
