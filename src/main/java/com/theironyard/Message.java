package com.theironyard;

/**
 * Created by benjamindrake on 11/9/15.
 */
public class Message {
    String post;
    int id;

    public Message(String post, int id) {
        this.post = post;
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public int getId() {
        return id;
    }
}
