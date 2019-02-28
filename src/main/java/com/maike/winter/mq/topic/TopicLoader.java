package com.maike.winter.mq.topic;

/**
 * Created by renxianlong on 16/10/19.
 */
public class TopicLoader {
    private static TopicLoader instance = new TopicLoader();

    private TopicLoader() {

    }

    //这个地方是为了加载常量类的静态属性,默认加载类的时候如果静态属性是对象jvm并不加载
    //只是暂时想不到更好的实现方式,如果可以,后面会优化
    public void init(){
        EvaluateTopic evaluateTopic = new EvaluateTopic();
        OrderTopic orderTopic = new OrderTopic();
        PostTopic postTopic = new PostTopic();
    }

    public static TopicLoader getInstance() {
        return instance;
    }
}
