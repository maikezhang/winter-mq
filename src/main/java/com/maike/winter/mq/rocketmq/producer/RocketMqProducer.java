package com.maike.winter.mq.rocketmq.producer;

import com.maike.winter.mq.config.MessageQueueService;
import com.maike.winter.mq.config.MqProducerConfig;
import com.maike.winter.mq.producer.IMessageCallBack;
import com.maike.winter.mq.producer.IProducer;
import com.maike.winter.mq.utils.KeyGenerator;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;


public class RocketMqProducer implements IProducer{
    public DefaultMQProducer producer;

    public static KeyGenerator keyGenerator = new KeyGenerator();

    private DefaultMessageCallBack callBack = new DefaultMessageCallBack();

    private Logger logger = LoggerFactory.getLogger(RocketMqProducer.class);

    @Resource
    private MessageQueueService mqService;

    public RocketMqProducer() {
    }

    private void send(String topic, String key, byte[] message) {
        Message msg = new Message();
        msg.setBody(message);
        msg.setKeys(key);
        msg.setTopic(topic);
        try {
            logger.debug("send Msg to rocketMq: topic " + topic + ", key " + key);
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    com.maike.winter.mq.producer.SendResult sendResult1 = new com.maike.winter.mq.producer.SendResult(sendResult.getMessageQueue().getTopic(),sendResult.getMsgId());
                    callBack.onSendSuccess(sendResult1);
                }

                @Override
                public void onException(Throwable e) {
                    callBack.onSendFaild(e);
                }
            });
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void send(String topic, String key, byte[] message, final IMessageCallBack messageCallBack) {
        Message msg = new Message();
        msg.setBody(message);
        msg.setKeys(key);
        msg.setTopic(topic);
        try {
//            logger.debug("send Msg to rocketMq: topic " + topic + ", key " + key);
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    com.maike.winter.mq.producer.SendResult result = new com.maike.winter.mq.producer.SendResult(sendResult.getMessageQueue().getTopic(),sendResult.getMsgId());
                    messageCallBack.onSendSuccess(result);
                }
                @Override
                public void onException(Throwable e)
                {
                    messageCallBack.onSendFaild(e);
                }
            });
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(com.maike.winter.mq.message.Message message) {
        send(message.getTopic().getTopic(),message.getKey(),message.getTopic().serize(message.getBody()));
    }

    @Override
    public void init(MqProducerConfig config) {
        producer = new DefaultMQProducer();
        producer.setNamesrvAddr(config.getClusterAddr());
        producer.setProducerGroup(config.getProducerName());
        producer.setInstanceName(config.getProducerName());
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        producer.shutdown();
    }
}
