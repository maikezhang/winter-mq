package com.maike.winter.mq.consumer;

import com.maike.winter.mq.rocketmq.consumer.RocketMqConsumer;

/**
 * Created by maikezhang on 16/3/27.
 */
public class ConsumerManager {

    public static ConsumerManager manager = new ConsumerManager();

    public IConsumer getConsumer(){
        return new RocketMqConsumer();
    }

    private ConsumerManager(){

    }

    public static ConsumerManager getInstance(){
         return manager;
    }
}
