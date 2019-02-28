package com.maike.winter.mq.config;

/**
 * Created by renxianlong on 16/3/27.
 */
public class MqProducerConfig extends MqConfig{
    private static final int DEFAULT_SEND_MSG_TIMEOUT = 3000;
    //生产者名字
    private String producerName;
    //发送超时时间
    private int sendMsgTimeout = DEFAULT_SEND_MSG_TIMEOUT;
    //消息超过多大开始压缩,默认4k
    private int compressMsgBodyOverHowmuch = 1024 * 4;
    //发送失败重试次数
    private int retryTimesWhenSendFailed = 2;
    //消息大小限制,默认128K
    private int maxMessageSize = 1024 * 128;

    private INameGenerater generater = new RandomNameGenerater();

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public int getSendMsgTimeout() {
        return sendMsgTimeout;
    }

    public void setSendMsgTimeout(int sendMsgTimeout) {
        this.sendMsgTimeout = sendMsgTimeout;
    }

    public int getCompressMsgBodyOverHowmuch() {
        return compressMsgBodyOverHowmuch;
    }

    public void setCompressMsgBodyOverHowmuch(int compressMsgBodyOverHowmuch) {
        this.compressMsgBodyOverHowmuch = compressMsgBodyOverHowmuch;
    }

    public int getRetryTimesWhenSendFailed() {
        return retryTimesWhenSendFailed;
    }

    public void setRetryTimesWhenSendFailed(int retryTimesWhenSendFailed) {
        this.retryTimesWhenSendFailed = retryTimesWhenSendFailed;
    }

    public int getMaxMessageSize() {
        return maxMessageSize;
    }

    public void setMaxMessageSize(int maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
    }

    public INameGenerater getGenerater() {
        return generater;
    }

    public void setGenerater(INameGenerater generater) {
        this.generater = generater;
    }
}
