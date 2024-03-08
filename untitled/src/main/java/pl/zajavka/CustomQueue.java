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

    }

    private void handleEnterByQueue(Deque<T> customerQueueVIP) {

    }

    public void leave(T item) {

    }


}
