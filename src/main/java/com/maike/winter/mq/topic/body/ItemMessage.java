//package com.maike.winter.mq.topic.body;
//
//
//public class ItemMessage extends MessageHeader {
//    private static final long serialVersionUID = -763246286140311102L;
//    //商品id
//    private Long id;
//    //商品名称
//    private String title;
//    //商品类型
//    private Integer type;
//    //商品starttm
//    private Long starttm;
//    //商品开售时间
//    private Long saletm;
//    //商品对应的pid
//    private Long pid;
//    //活动开始时间
//    private Long activitystarttm;
//    //商品销售状态
//    protected Integer salestatus;
//
//    public ItemMessage(String uniqueId, Integer af, Long uid, String appVersion) {
//        super(uniqueId, af, uid, appVersion);
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Integer getType() {
//        return type;
//    }
//
//    public void setType(Integer type) {
//        this.type = type;
//    }
//
//    public Long getStarttm() {
//        return starttm;
//    }
//
//    public void setStarttm(Long starttm) {
//        this.starttm = starttm;
//    }
//
//    public Long getSaletm() {
//        return saletm;
//    }
//
//    public void setSaletm(Long saletm) {
//        this.saletm = saletm;
//    }
//
//    public Long getPid() {
//        return pid;
//    }
//
//    public void setPid(Long pid) {
//        this.pid = pid;
//    }
//
//    public Long getActivitystarttm() {
//        return activitystarttm;
//    }
//
//    public void setActivitystarttm(Long activitystarttm) {
//        this.activitystarttm = activitystarttm;
//    }
//
//    public Integer getSalestatus() {
//        return salestatus;
//    }
//
//    public void setSalestatus(Integer salestatus) {
//        this.salestatus = salestatus;
//    }
//
//    public void loadFromPojo(ItemPext itemPext) {
//        this.id = itemPext.getIid();
//        this.title = itemPext.getTitle();
//        this.type = itemPext.getType();
//        this.starttm = itemPext.getStarttm();
//        this.saletm = itemPext.getSaletm();
//        this.pid = itemPext.getPid();
//        this.activitystarttm = itemPext.getActivitystarttm();
//        this.salestatus = itemPext.getSalestatus();
//    }
//}
