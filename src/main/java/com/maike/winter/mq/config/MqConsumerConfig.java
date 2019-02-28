package com.maike.winter.mq.config;

import com.maike.winter.mq.message.IMessageHandler;

import java.util.Map;

/**
 * Created by renxianlong on 16/3/27.
 */
public class MqConsumerConfig extends MqConfig {
    //消费组
    private String consumerGroup;
    //此消费者名字
    private String consumerName;
    //消费模式0:集群1:广播,默认集群消费,即同一消费组负载均衡
    private int consumeMode = 0;

    private INameGenerater               generater;
    //消费者对应topic以及其处理方法
    private Map<String, IMessageHandler> handler;

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public int getConsumeMode() {
        return consumeMode;
    }

    public void setConsumeMode(int consumeMode) {
        this.consumeMode = consumeMode;
    }

    public Map<String, IMessageHandler> getHandler() {
        return handler;
    }

    public void setHandler(Map<String, IMessageHandler> handler) {
        this.handler = handler;
    }

    public INameGenerater getGenerater() {
        return generater;
    }

    public void setGenerater(INameGenerater generater) {
        this.generater = generater;
    }
}
