package com.maike.winter.mq.rocketmq.consumer;

import com.maike.winter.mq.config.MqConsumerConfig;
import com.maike.winter.mq.consumer.IConsumer;
import com.maike.winter.mq.consumer.TopicHandlerManager;
import com.maike.winter.mq.message.IMessageHandler;
import com.maike.winter.mq.topic.Topic;
import com.maike.winter.mq.topic.TopicLoader;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.maike.winter.mq.Constant.SUBSCRIBE_ALL;

/**
 * Created by renxianlong on 16/3/27.
 */
public class RocketMqConsumer implements IConsumer{

    DefaultMQPushConsumer consumer;

    private Logger logger = LoggerFactory.getLogger(RocketMqConsumer.class);

    private Logger interfaceLogger = LoggerFactory.getLogger("mqdispacher");

    @Override
    public void init(MqConsumerConfig config) {
        consumer = new DefaultMQPushConsumer();
        consumer.setNamesrvAddr(config.getClusterAddr());
        consumer.setConsumerGroup(config.getConsumerGroup());
        consumer.setMessageModel(1 == config.getConsumeMode()? MessageModel.BROADCASTING : MessageModel.CLUSTERING);
        TopicHandlerManager.getInstance().registTopicHandler(config.getHandler());
        subscribe(TopicHandlerManager.getInstance().getTopics(),consumer);
        TopicLoader.getInstance().init();
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                if(!CollectionUtils.isEmpty(msgs)){
                    for(MessageExt msg : msgs){
                        interfaceLogger.info("receive message " + msg);
                        String topic = msg.getTopic();
                        Topic tp = Topic.topicMap.get(topic);
                        if (null == tp){
                            logger.error("this topic " + topic + " is ellegal" );
                            continue;
                        }

                        IMessageHandler messageHandler =  TopicHandlerManager.getInstance().getTopicHandler(topic);
                        String key = msg.getKeys();
                        messageHandler.handle(key, tp.getBody(msg.getBody()));
                        interfaceLogger.info("handle message " + msg.getMsgId() + " end");
                    }
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        consumer.shutdown();
    }

    private void subscribe(Set<String> topics, DefaultMQPushConsumer consumer) {
        if(CollectionUtils.isNotEmpty(topics)){
           Iterator<String> it = topics.iterator();
            while (it.hasNext()) {
                String topic = it.next();
                try {
                    consumer.subscribe(topic,SUBSCRIBE_ALL);
                } catch (MQClientException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
