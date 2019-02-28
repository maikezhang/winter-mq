package com.maike.winter.mq.consumer;

/**
 * Created by renxianlong on 16/5/9.
 */
public class ByteContainer {
    private byte[] body;

    public ByteContainer(byte[] body) {
        this.body = body;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
