package com.maike.winter.mq.consumer;

import com.maike.winter.mq.message.IMessageHandler;
import com.maike.winter.mq.annocation.TopicHandler;
import com.maike.winter.mq.rocketmq.consumer.DefaultTopicHandler;
import com.alibaba.dubbo.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by maikezhang on 16/4/8.
 */
public class TopicHandlerManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicHandlerManager.class);

    public static TopicHandlerManager instance = new TopicHandlerManager();
    //任务执行者,根据不同的jobtype可以自己注册不同的TaskRunner
    private Map<String, IMessageHandler> handlerMap = new ConcurrentHashMap<String, IMessageHandler>();

    private TopicHandlerManager() {
    }

    public static TopicHandlerManager getInstance() {
        return instance;
    }

    public void registTopicHandler(String topic, IMessageHandler handler) {
        handlerMap.put(topic, handler);
    }

    public void registTopicHandler(Map<String, IMessageHandler> handler) {
        if (null == handler || handler.isEmpty()){
            return;
        }
        handlerMap.putAll(handler);
    }


    public IMessageHandler getTopicHandler(String topic) {
        if (null != topic) {
            IMessageHandler handler = handlerMap.get(topic);
            if (null != handler) {
                return handler;
            }
        }
        return new DefaultTopicHandler();
    }

    public Set<String> getTopics(){
        return handlerMap.keySet();
    }

    public void addTopicHandler(Object bean) {
        Class<?> clazz = bean.getClass();
        Method[] methods = clazz.getMethods();
        if (methods != null && methods.length > 0) {
            for (final Method method : methods) {
                LOGGER.debug("解析method:" + method);
                if (method.isAnnotationPresent(TopicHandler.class)) {
                    TopicHandler topicHandler = method.getAnnotation(TopicHandler.class);
                    String topic = topicHandler.topic();
                    if (StringUtils.isEmpty(topic)) {
                        LOGGER.error(clazz.getName() + ":" + method.getName() + " " + TopicHandler.class.getName() + " topic can not be null");
                        continue;
                    }
                    handlerMap.put(topic, TopicHandlerBuilder.build(bean, method, method.getParameterTypes()));
                    LOGGER.debug("注册topicHandler for :" + topic + "成功");
                }
            }
        }
    }
}
