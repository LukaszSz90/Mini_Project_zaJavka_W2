package pl.zajavka;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CustomQueue<T> {
    private final Deque<T> customerQueue;
    private final Deque<T> customerQueueVIP;

    private final Map<String, Integer> counterMap = new HashMap<>();

    public CustomQueue(Deque<T> customerQueue, Deque<T> customerQueueVIP) {
        this.customerQueue = customerQueue;
        this.customerQueueVIP = customerQueueVIP;
    }

    public void incomeVip(T item) {
        boolean isAdded = customerQueueVIP.offer(item);
        System.out.printf("%s came to the VIP queue: %s%n", item, isAdded);
        System.out.println(customerQueue);
        System.out.println();
    }

    public void incomeCustomer(T item) {
        boolean isAdded = customerQueue.offer(item);
        System.out.printf("%s came to the VIP queue: %s%n", item, isAdded);
        System.out.println(customerQueue);
        System.out.println();
    }

    public Integer getCustomerAndIncrementCounter(String key) {
        Integer counter = counterMap.getOrDefault(key, 0);
        counterMap.put(key, ++counter);
        return counter;
    }

    public void enterIntoStore() {
        if (customerQueue.isEmpty()) {
            System.out.println("No item in the queue.");
        } else {
            handleEnterByQueue(customerQueueVIP);
            return;
        }

        T itemEntered = customerQueue.poll();

        System.out.printf("Processing queue: %s arrived at the store", itemEntered);
        System.out.println(customerQueue);
        System.out.println();
    }

    private void handleEnterByQueue(Deque<T> customerQueueVIP) {
        T itemEntered = customerQueueVIP.poll();
        System.out.printf("Processing queue: %s arrived at the store", itemEntered);
    }

    public void leave(T item) {
        if (customerQueue.contains(item)) {
            customerQueue.remove(item);
            System.out.printf("Leaving queue: %s", item);
            System.out.println(customerQueue);
            System.out.println();
        } else {
            System.out.printf(item + " currently is not in the queue.\n");
        }
    }


}
