package com.maike.winter.mq.consumer;

import com.maike.winter.mq.config.MessageQueueService;
import com.maike.winter.mq.config.MqConsumerConfig;

import javax.annotation.Resource;

/**
 * Created by maikezhang on 16/3/28.
 */
public class Consumer extends MqConsumerConfig {

    private IConsumer delegate;

    @Resource
    private MessageQueueService configService;

    public void init(MqConsumerConfig config) {
        if (null == getClusterAddr()) {
            this.setClusterAddr(configService.getMqConfig().getClusterAddr());
        }

        if (null != getGenerater()) {
            config.setConsumerName(getGenerater().generateName(config.getConsumerName()));
        }

        delegate = ConsumerManager.getInstance().getConsumer();
        delegate.init(config);
    }

    public void start() {
        delegate.start();
    }

    public void stop() {
        delegate.stop();
    }

    public void initBean() {
        init(this);
    }
}
