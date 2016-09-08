package com.rgubaidullin;

import java.util.PriorityQueue;

/**
 * Created by Renat_Gubaidullin on 9/3/2016.
 */
public class ProducerConsumerMultiService {
    public static void main(String[] args) {
        //Creating of queue
        PriorityQueue<Message> queue = new PriorityQueue();
        //Creating of producers with different topics
        Producer producer_1 = new Producer(queue, "book");
        Producer producer_2 = new Producer(queue, "pen");
        Producer producer_3 = new Producer(queue, "bag");
        Producer producer_4 = new Producer(queue, "note");
        Producer producer_5 = new Producer(queue, "pencil");
        //Creating of consumers  with different topics
        Consumer consumer_1 = new Consumer(queue, "book");
        Consumer consumer_2 = new Consumer(queue, "pen");;
        Consumer consumer_3 = new Consumer(queue, "bag");
        Consumer consumer_4 = new Consumer(queue, "note");
        Consumer consumer_5 = new Consumer(queue, "pencil");

        //starting producer threads to produce messages in queue
        new Thread(producer_1).start();
        new Thread(producer_2).start();
        new Thread(producer_3).start();
        new Thread(producer_4).start();
        new Thread(producer_5).start();

        //starting consumers threads to consume messages from queue
        new Thread(consumer_1).start();
        new Thread(consumer_2).start();
        new Thread(consumer_3).start();
        new Thread(consumer_4).start();
        new Thread(consumer_5).start();

        System.out.println("Producer and Consumer has been started");
    }
}
