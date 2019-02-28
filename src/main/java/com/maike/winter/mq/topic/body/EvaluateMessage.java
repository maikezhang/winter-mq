package com.maike.winter.mq.topic.body;


public class EvaluateMessage extends MessageHeader {
    private static final long serialVersionUID = -4773720614222798215L;
    //商品id
    private Long iid;
    //分享id
    private Long pid;
    //评价id
    private Long eid;
    //订单id
    private String ooid;
    //用户名
    private String username;
    //状态
    private Integer status;
    //评论内容
    private String content;

    public EvaluateMessage(String uniqueId, Integer af, Long uid, String appVersion) {
        super(uniqueId, af, uid, appVersion);
    }

    public Long getIid() {
        return iid;
    }

    public void setIid(Long iid) {
        this.iid = iid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getOoid() {
        return ooid;
    }

    public void setOoid(String ooid) {
        this.ooid = ooid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
