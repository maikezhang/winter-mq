package com.maike.winter.mq.topic;

import com.maike.winter.mq.topic.body.PostMessage;

/**
 * 分享相关topic
 */
public class PostTopic {
    public static final String POST_ADD_TOPIC = "post_add";
    public static final String POST_UPDATE_TOPIC = "post_update";
    public static final String POST_DELETE_TOPIC = "post_delete";

    public static final Topic<PostMessage> ADD    = new Topic<PostMessage>("post_add", PostMessage.class);
    public static final Topic<PostMessage> UPDATE = new Topic<PostMessage>("post_update", PostMessage.class);
    public static final Topic<PostMessage> DELETE = new Topic<PostMessage>("post_delete", PostMessage.class);
}