package Com.Queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();

        queue.put(new DelayedElement("Element1", 5));
        queue.put(new DelayedElement("Element2", 3));
        queue.put(new DelayedElement("Element3", 1));

        while (!queue.isEmpty()) {
            DelayedElement element = queue.take();
            System.out.println("Took: " + element.getName());
        }
    }
}

class DelayedElement implements Delayed {
    private String name;
    private long delay;

    public DelayedElement(String name, long delay) {
        this.name = name;
        this.delay = System.nanoTime() + TimeUnit.SECONDS.toNanos(delay);
    }

    public String getName() {
        return name;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delay - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.NANOSECONDS), o.getDelay(TimeUnit.NANOSECONDS));
    }
}