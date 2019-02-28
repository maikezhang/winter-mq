package com.maike.winter.mq.config;

import java.io.Serializable;

/**
 * Created by maikezhang on 16/3/27.
 */
public class MqConfig implements Serializable {

    //集群ip地址和端口,多地址分好分开
    private String clusterAddr;

    public String getClusterAddr() {
        return clusterAddr;
    }

    public void setClusterAddr(String clusterAddr) {
        this.clusterAddr = clusterAddr;
    }
}
