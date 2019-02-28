package com.maike.winter.mq.config;

import java.util.Random;

/**
 * Created by renxianlong on 16/9/28.
 */
public class RandomNameGenerater implements INameGenerater {
    private Random random = new Random();
    @Override
    public String generateName(String prefix) {
        return prefix + random.nextInt(10000);
    }
}
