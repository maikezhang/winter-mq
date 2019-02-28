package com.maike.winter.mq.utils;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * Description:
 * Created with IntelliJ IDEA.
 * User: zhangyingjie
 * Date: 2019/2/28
 * Time: 上午11:18
 */
public class ProtostuffSerialize<T> {

    private static final Integer BUFFER_SIZE = 1024;

    private Schema<T> schema;

    private ProtostuffSerialize(Class<T> tClazz) {
        schema = RuntimeSchema.getSchema(tClazz);
    }

    public byte[] encoder(T t) {
        LinkedBuffer buffer = LinkedBuffer.allocate(BUFFER_SIZE);
        return ProtostuffIOUtil.toByteArray(t, schema, buffer);
    }

    public T decoder(byte[] data, T t) {
        ProtostuffIOUtil.mergeFrom(data, t, schema);
        return t;
    }

    /**
     * 获取对象实例
     *
     * @param clazz 需要编解码的类
     */
    public static <T> ProtostuffSerialize getInstance(Class<T> clazz) {
        return new ProtostuffSerialize<T>(clazz);
    }

}
