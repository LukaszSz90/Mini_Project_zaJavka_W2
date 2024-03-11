package pl.zajavka;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class QueueCommand<T> {

    private Deque<T> queueVIP;
    private Deque<T> queue;

    private Map<String,Integer> countCustomer = new HashMap<>();

    public QueueCommand(Deque<T> queueVIP, Deque<T> queue) {
        this.queueVIP = queueVIP;
        this.queue = queue;
    }

    public void joinToQueue(T element) {
        boolean isAdded = queue.offer(element);

    }

    public void joinToQueueVip() {

    }

    public void enterToStore() {

    }

    public void leaveQueue() {

    }

    private void enterToStoreVip() {

    }

    public Integer checkAndIncrementCount(String elementKey) {

        return 1;
    }

}
