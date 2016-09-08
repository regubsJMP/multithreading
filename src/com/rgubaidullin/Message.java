package com.rgubaidullin;

/**
 * Created by Renat_Gubaidullin on 9/2/2016.
 */
public class Message implements Comparable{
    private String body;

    public Message(String str){
        this.body=str;
    }

    public String getMsg() {
        return body;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
