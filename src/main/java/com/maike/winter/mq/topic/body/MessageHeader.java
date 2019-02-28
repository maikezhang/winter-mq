package com.maike.winter.mq.topic.body;


import com.maike.winter.mq.utils.Base;

public abstract class MessageHeader extends Base {

    private static final long serialVersionUID = -7053969778256720639L;

    //请求唯一ID，用来追踪整个请求的处理流程
    protected String uniqueId;

    //adminFlag,标识用户类型:0 普通用户 1 管理员 2 系统用户
    protected Integer af = 0;

    //操作人uid
    protected Long uid;

    //APP版本号
    protected String appVersion;

    public MessageHeader(String uniqueId, Integer af, Long uid, String appVersion) {
        this.uniqueId = uniqueId;
        this.af = af;
        this.uid = uid;
        this.appVersion = appVersion;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Integer getAf() {
        return af;
    }

    public void setAf(Integer af) {
        this.af = af;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
