package com.maike.winter.mq.utils;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Description:
 * Created with IntelliJ IDEA.
 * User: zhangyingjie
 * Date: 2019/2/28
 * Time: 上午10:08
 */
public class Base implements Serializable {

    private static final Gson GSON=new Gson();


    @Override
    public String toString(){
        return GSON.toJson(this);
    }

}
