package com.maike.winter.mq.message;

import com.maike.winter.mq.topic.Topic;

/**
 * Created by renxianlong on 16/9/29.
 */
public class Message <T> {
    private Topic<T> topic;
    private String   key;
    private T        body;

    public Topic<T> getTopic() {
        return topic;
    }

    public void setTopic(Topic<T> topic) {
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
