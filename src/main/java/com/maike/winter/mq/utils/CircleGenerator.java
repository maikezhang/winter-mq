package com.maike.winter.mq.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * Created with IntelliJ IDEA.
 * User: zhangyingjie
 * Date: 2019/2/28
 * Time: 上午11:10
 */
public class CircleGenerator {
    private static final int           DEFAULT_COLUMN = 10;
    private              AtomicInteger sequence       = new AtomicInteger(1);
    private int length;
    private List<String> prefix = new ArrayList<String>();

    private void initPrefix(int length) {
        for (int i = 0; i < length - 1; i++) {
            String s = "";
            for (int j = 0; j < i + 1; j++) {
                s += "0";
            }
            prefix.add(s);
        }
    }

    public CircleGenerator(int length) {
        this.length = length;
        initPrefix(length);
        System.out.print(prefix);
    }

    public String generate() {
        sequence.compareAndSet(pow(DEFAULT_COLUMN, length), 1);
        String seq = String.valueOf(sequence.getAndAdd(1));
        if (seq.length() < length) {
            seq = prefix.get(length - seq.length() - 1) + seq;
        }
        return seq;
    }

    public int pow(int m, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= m;
        }
        return result;
    }
}
