package com.maike.winter.mq.topic.body;

public class PostMessage extends MessageHeader {
    private static final long serialVersionUID = 3236826932814506583L;
    // 分享id
    private Long id;
    // 分享类型
    private Integer type;

    public PostMessage(String uniqueId, Integer af, Long uid, String appVersion) {
        super(uniqueId, af, uid, appVersion);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}