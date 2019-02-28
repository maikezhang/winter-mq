package com.maike.winter.mq.rocketmq.consumer;

import com.maike.winter.mq.message.IMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by renxianlong on 16/3/28.
 */
public class DefaultTopicHandler implements IMessageHandler {

    Logger logger = LoggerFactory.getLogger(DefaultTopicHandler.class);

    @Override
    public void handle(String key , Object message) {
        logger.debug("consumer message successfully: key " + key + ", message " + message);
    }
}
