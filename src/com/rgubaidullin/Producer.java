package com.rgubaidullin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.PriorityQueue;
/**
 * Created by Renat_Gubaidullin on 9/2/2016.
 */
public class Producer implements Runnable{

    private PriorityQueue<Message> queue;
    private String topic = new String();
    private Set<Message> orders = new HashSet<Message>();
    public Producer(PriorityQueue queue, String topic){

        this.queue=queue;
        this.topic=topic;
    }

    @Override
    public void run() {
        //produce messages and put them randomly to queue via HashSet
        for(int i=0; i<100; i++) {
            Message msg = new Message(topic + "_" + i);
            orders.add(msg);
        }
        //add messages from hashset to queue to get random order
        Iterator iter = orders.iterator();
        while (iter.hasNext()) {
            synchronized (queue) {
                Message msg = (Message) iter.next();
                //queue.add((Message) iter.next());
                queue.add(msg);
            }
        }
    }
}
