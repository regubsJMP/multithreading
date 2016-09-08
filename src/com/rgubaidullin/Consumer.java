package com.rgubaidullin;

import java.util.PriorityQueue;

/**
 * Created by Renat_Gubaidullin on 9/3/2016.
 */
public class Consumer implements Runnable {

    private PriorityQueue<Message> queue;
    private String topic = new String();

    public Consumer(PriorityQueue<Message> queue, String topic){

        this.queue=queue;
        this.topic = topic;
    }

    @Override
    public void run() {
        Message msg;

        for (int i = 0; i<3; i++) { //give consumer 3 attempts in case of a queue is empty.
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //loop with synchronised block to lock non-sync queue for every polling.
            while (!queue.isEmpty()) {
                synchronized (queue) {
                    if (!queue.isEmpty()) {
                        msg = queue.poll();
                        String body = String.valueOf(msg.getMsg());
                        if (body.contains(topic)) {
                            System.out.println("Consumed " + body);
                        }
                        //return message to a queue if topic is not suitable.
                        else {
                            queue.add(msg);
                        }
                    }
                }
            }
        }
    }
}

