package com.rgubaidullin;

import java.util.PriorityQueue;

/**
 * Created by Renat_Gubaidullin on 9/3/2016.
 */
public class ProducerConsumerService {
    public static void main(String[] args) {
        //Creating queue
        PriorityQueue<Message> queue = new PriorityQueue();
        Producer producer = new Producer(queue, "book");
        Producer producer_2 = new Producer(queue, "wqq");
        Consumer consumer = new Consumer(queue, "book");
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer thread to produce messages in queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }
}
