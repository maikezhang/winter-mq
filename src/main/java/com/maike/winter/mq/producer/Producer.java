package com.maike.winter.mq.producer;

import com.maike.winter.mq.config.MessageQueueService;
import com.maike.winter.mq.config.MqProducerConfig;
import com.maike.winter.mq.message.Message;

import javax.annotation.Resource;

/**
 * Created by renxianlong on 16/3/27.
 */
public class Producer extends MqProducerConfig implements IProducer{
    private IProducer delegate;
    @Resource
    private MessageQueueService configService;

    //在这里需要初始化producer
    public Producer(){
    }

    @Override
    public void send(Message message) {
        delegate.send(message);
    }
    @Override
    public void init(MqProducerConfig config) {
        if(null == getClusterAddr()){
            this.setClusterAddr(configService.getMqConfig().getClusterAddr());
        }
        delegate = ProducerManager.getInstance().getProducer();

        if (null != getGenerater() ){
            config.setProducerName(getGenerater().generateName(config.getProducerName()));
        }
        delegate.init(config);
    }

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    public void initBean(){
        init(this);
    }
}
