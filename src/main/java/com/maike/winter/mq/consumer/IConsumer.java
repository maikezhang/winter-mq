package com.maike.winter.mq.consumer;

import com.maike.winter.mq.config.MqConsumerConfig;

/**
 * Created by maikezhang on 16/3/27.
 */
public interface IConsumer {
     void init(MqConsumerConfig config);

     void start();

     void stop();
}
