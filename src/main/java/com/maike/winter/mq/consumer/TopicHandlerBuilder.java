package com.maike.winter.mq.consumer;

import com.maike.winter.mq.message.IMessageHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Robert HG (254963746@qq.com) on 4/2/16.
 */
public class TopicHandlerBuilder {
    public static IMessageHandler build(final Object targetObject, final Method targetMethod, final Class<?>[] pTypes) {
        //参数必须为1到2个 一个key 一个message 或者只有message
        if (null == pTypes || pTypes.length < 1 || pTypes.length > 2) {
            return null;
        }

        if (pTypes.length == 1) {
            //只有message参数
            final Class paramType = pTypes[0];
            return new IMessageHandler() {
                @Override
                public void handle(String key, Object message) {
                    try {
                        targetMethod.invoke(paramType.cast(message));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            };
        }

        return new IMessageHandler() {
            Class paramType = pTypes[1];

            @Override
            public void handle(String key, Object message) {
                try {
                    targetMethod.invoke(key, paramType.cast(message));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        };


    }
}
