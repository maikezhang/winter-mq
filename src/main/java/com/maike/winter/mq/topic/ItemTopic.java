//package com.maike.winter.mq.topic;
//
//import com.maike.winter.mq.topic.body.ItemMessage;
//
//
///**
// * Created by maikezhang on 16/9/29.
// * 商品相关topic
// */
//public class ItemTopic {
//    public static final String ITEM_ADD_TOPIC = "item_add";
//    public static final String ITEM_UPDATE_TOPIC = "item_update";
//    public static final String ITEM_DELETE_TOPIC = "item_delete";
//    public static final String ITEM_ONSHELF_TOPIC = "item_onshelf";
//    public static final String ITEM_OFFSHELF_TOPIC = "item_offshelf";
//
//    public static final Topic<ItemMessage> ADD = new Topic<>(ITEM_ADD_TOPIC, ItemMessage.class);
//    public static final Topic<ItemMessage> UPDATE = new Topic<>(ITEM_UPDATE_TOPIC, ItemMessage.class);
//    public static final Topic<ItemMessage> DELETE = new Topic<>(ITEM_DELETE_TOPIC, ItemMessage.class);
//    public static final Topic<ItemMessage> ONSHELF = new Topic<>(ITEM_ONSHELF_TOPIC, ItemMessage.class);
//    public static final Topic<ItemMessage> OFFSHELF = new Topic<>(ITEM_OFFSHELF_TOPIC, ItemMessage.class);
//}