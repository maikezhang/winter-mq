package com.maike.winter.mq.message;

/**
 * Created by maikezhang on 16/3/14.
 */
public interface IMessageHandler {
    void handle(String key, Object message);
}
