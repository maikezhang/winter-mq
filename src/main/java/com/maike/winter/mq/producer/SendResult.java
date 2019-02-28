package com.maike.winter.mq.producer;

/**
 * Created by maikezhang on 16/3/28.
 */
public class SendResult {
    //该消息对应topic
    private String topic;
    //该消息对应的msgId
    private String msgId;

    public SendResult(String topic, String msgId) {
        this.topic = topic;
        this.msgId = msgId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
