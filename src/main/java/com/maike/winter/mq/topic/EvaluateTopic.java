package com.maike.winter.mq.topic;

import com.maike.winter.mq.topic.body.EvaluateMessage;

/**
 * Created by renxianlong on 16/9/29.
 * 商品相关topic
 */
public class EvaluateTopic {
    public static final String EVALUATE_ADD_TOPIC = "evaluate_add";
    public static final String EVALUATE_UPDATE_TOPIC = "evaluate_update";
    public static final String EVALUATE_DELETE_TOPIC = "evaluate_delete";
    public static final String EVALUATE_RECOMMEND_TOPIC = "evaluate_recommend";
    public static final String EVALUATE_CANCEL_RECOMMEND_TOPIC = "evaluate_cancel_recommend";

    public static final Topic<EvaluateMessage> ADD              = new Topic<EvaluateMessage>(EVALUATE_ADD_TOPIC, EvaluateMessage.class);
    public static final Topic<EvaluateMessage> UPDATE           = new Topic<EvaluateMessage>(EVALUATE_UPDATE_TOPIC, EvaluateMessage.class);
    public static final Topic<EvaluateMessage> DELETE           = new Topic<EvaluateMessage>(EVALUATE_DELETE_TOPIC, EvaluateMessage.class);
    public static final Topic<EvaluateMessage> RECOMMEND        = new Topic<EvaluateMessage>(EVALUATE_RECOMMEND_TOPIC, EvaluateMessage.class);
    public static final Topic<EvaluateMessage> CANCEL_RECOMMEND = new Topic<EvaluateMessage>(EVALUATE_CANCEL_RECOMMEND_TOPIC, EvaluateMessage.class);
}