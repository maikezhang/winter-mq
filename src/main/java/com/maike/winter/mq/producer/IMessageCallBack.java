package com.maike.winter.mq.producer;


/**
 * Created by maikezhang on 16/3/27.
 */
public interface IMessageCallBack {
    void onSendSuccess(SendResult sendResult);

    void onSendFaild(Throwable e);
}
