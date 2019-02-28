package com.maike.winter.mq.utils;

/**
 * Description:
 * Created with IntelliJ IDEA.
 * User: zhangyingjie
 * Date: 2019/2/28
 * Time: 上午10:55
 */
public class KeyGenerator {

    private static final int DEFAULT_SEQUENCE_LENGTH = 4;

    private CircleGenerator generator = new CircleGenerator(DEFAULT_SEQUENCE_LENGTH);

    private String prefix = "";

    public KeyGenerator(String prefix) {
        this.prefix = prefix;
    }

    public KeyGenerator() {
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String generateKey() {
        return prefix + System.currentTimeMillis() + generator.generate();
    }
}
