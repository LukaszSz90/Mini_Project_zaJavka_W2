package pl.zajavka;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class QueueCommand<T> {

    private Deque<T> queueVIP;
    private Deque<T> queue;

    private Map<String,Integer> countCustomerMap = new HashMap<>();

    public QueueCommand(Deque<T> queueVIP, Deque<T> queue) {
        this.queueVIP = queueVIP;
        this.queue = queue;
    }

    public void joinToQueueVip(T element) {
        boolean isAdded = queueVIP.offer(element);
        System.out.printf("%s came to the queue: %s%n", element, isAdded);
        System.out.println("Queue: " + queue);
        System.out.println();
    }

    public void joinToQueue(T element) {
        boolean isAdded = queue.offer(element);
        System.out.printf("%s came to the queue: %s%n", element, isAdded);
        System.out.println("Queue: " + queue);
        System.out.println();
    }

    public Integer checkAndIncrementCount(String elementKey) {
        Integer count = countCustomerMap.getOrDefault(elementKey, 0);
        countCustomerMap.put(elementKey, ++count);
        return count;
    }

    public void enterToStore() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            enterToStoreVip(queueVIP);
            return;
        }

        T enteredElement = queue.poll();

        System.out.printf("Processing queue: %s arrived at store", enteredElement);
        System.out.println("Queue: " + queue);
        System.out.println();
    }

    private void enterToStoreVip(Deque<T> queueVIP) {
        T enteredElement = queueVIP.poll();
        System.out.printf("Processing queue: %s arrived at the store", enteredElement);
    }

    public void leaveQueue(T item) {
        if (queue.contains(item)) {
            queue.remove(item);
            System.out.println("Leaving queue: " + item);
            System.out.println("Queue: " + queue);
            System.out.println();
        } else {
            System.out.println(item + " is not currently in queue.");
        }
    }


}
