package com.maike.winter.mq.producer;

import com.maike.winter.mq.rocketmq.producer.RocketMqProducer;

/**
 * Created by maikezhang on 16/3/27.
 */
public class ProducerManager {

    public static ProducerManager instance = new ProducerManager();

    public static ProducerManager getInstance(){
        return instance;
    }

    public IProducer getProducer(){
        return new RocketMqProducer();
    }

    private ProducerManager(){

    }
}
