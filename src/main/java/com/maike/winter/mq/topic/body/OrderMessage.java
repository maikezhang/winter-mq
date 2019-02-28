package com.maike.winter.mq.topic.body;

public class OrderMessage extends MessageHeader {
    private static final long serialVersionUID = -6906476959637595835L;
    // 订单id
    private String id;

    public OrderMessage(String uniqueId, Integer af, Long uid, String appVersion) {
        super(uniqueId, af, uid, appVersion);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}