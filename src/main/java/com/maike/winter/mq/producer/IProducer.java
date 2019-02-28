package com.maike.winter.mq.producer;

import com.maike.winter.mq.config.MqProducerConfig;
import com.maike.winter.mq.message.Message;

/**
 * Created by renxianlong on 16/3/27.
 */
public interface IProducer {
    void send(Message message);
    //初始化
    void init(MqProducerConfig config);

    void start();

    void stop();
}
