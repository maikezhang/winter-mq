package com.maike.winter.mq.annocation;

import com.maike.winter.mq.consumer.TopicHandlerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.regex.Pattern;

/**
 * Created by maikezhang on 16/8/17.
 */
public class MqListenerScanner implements BeanPostProcessor{

    private static final Logger LOGGER = LoggerFactory.getLogger(MqListenerScanner.class);

    private String[] annotationPackages;

    public void setBasePackage(String annotationPackage) {
        this.annotationPackages = (annotationPackage == null || annotationPackage.length() == 0) ? null
                : Pattern.compile("\\s*[,]+\\s*").split(annotationPackage);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOGGER.debug("开始注册bean" + beanName);
        Class<?> clazz = bean.getClass();

        if (!isMatchPackage(clazz)) {
            return bean;
        }

        if (!clazz.isAnnotationPresent(MqListener.class)) {
            return bean;
        }

        LOGGER.debug("开始注册taskRunner" + beanName);
        TopicHandlerManager.getInstance().addTopicHandler(bean);

        return bean;
    }


    private boolean isMatchPackage(Class<?> clazz) {
        if (annotationPackages == null || annotationPackages.length == 0) {
            return true;
        }
        String beanClassName = clazz.getName();
        for (String pkg : annotationPackages) {
            if (beanClassName.startsWith(pkg)) {
                return true;
            }
        }
        return false;
    }
}
