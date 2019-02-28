package com.maike.winter.mq.topic;

import com.maike.winter.mq.topic.body.OrderMessage;

/**
 * Created by renxianlong on 16/9/29.
 * 订单相关topic
 */
public class OrderTopic {
    public static final String ORDER_ADD_TOPIC = "order_add";
    public static final String ORDER_UPDATE_TOPIC = "order_update";
    public static final String ORDER_DELETE_TOPIC = "order_delete";

    public static final Topic<OrderMessage> ADD    = new Topic<OrderMessage>(ORDER_ADD_TOPIC, OrderMessage.class);
    public static final Topic<OrderMessage> UPDATE = new Topic<OrderMessage>(ORDER_UPDATE_TOPIC, OrderMessage.class);
    public static final Topic<OrderMessage> DELETE = new Topic<OrderMessage>(ORDER_DELETE_TOPIC, OrderMessage.class);
}