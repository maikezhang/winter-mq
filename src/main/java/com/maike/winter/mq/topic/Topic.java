package com.maike.winter.mq.topic;


import com.maike.winter.mq.utils.ProtostuffSerialize;

import java.util.HashMap;
import java.util.Map;

public class Topic<T> implements ITopic<T> {
    public static Map<Class, ProtostuffSerialize> serializeMap = new HashMap<Class, ProtostuffSerialize>();

    public static Map<String, Topic> topicMap = new HashMap<String, Topic>();

    private String topic;

    private Class<T> ext;

    Topic(String topic) {
        this.topic = topic;
        topicMap.put(topic, this);
    }

    Topic(String topic, Class<T> ext) {
        this.topic = topic;
        this.ext = ext;
        topicMap.put(topic, this);
    }

    @Override
    public String getTopic() {
        return this.topic;
    }

    public T getBody(byte[] bytes) {
        if (null == bytes || bytes.length == 0) {
            return null;
        }
        try {
            ProtostuffSerialize<T> serialize = getSerialize();
            return serialize.decoder(bytes, ext.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] serize(T t) {
        ProtostuffSerialize<T> serialize = getSerialize();
        return serialize.encoder(t);
    }

    @SuppressWarnings("unchecked")
    private ProtostuffSerialize<T> getSerialize() {
        ProtostuffSerialize<T> serialize = serializeMap.get(ext);
        if (null == serialize) {
            serialize = ProtostuffSerialize.getInstance(ext);
            serializeMap.put(ext, serialize);
        }
        return serialize;
    }
}
