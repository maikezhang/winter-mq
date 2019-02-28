package com.maike.winter.mq.rocketmq.producer;

import com.maike.winter.mq.producer.IMessageCallBack;
import com.maike.winter.mq.producer.SendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by maikezhang on 16/3/27.
 */
public class DefaultMessageCallBack implements IMessageCallBack {

    Logger logger = LoggerFactory.getLogger(DefaultMessageCallBack.class);

    @Override
    public void onSendSuccess(SendResult sendResult) {
        logger.info("send message successfully, " +
                "topic " + sendResult.getTopic() + " msgId " + sendResult.getMsgId());
    }

    @Override
    public void onSendFaild(Throwable e) {
        logger.info("send message faild, cause by " + e.getMessage());
    }
}
