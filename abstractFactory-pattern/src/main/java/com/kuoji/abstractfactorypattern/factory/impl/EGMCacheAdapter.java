package com.kuoji.abstractfactorypattern.factory.impl;

import com.kuoji.abstractfactorypattern.factory.ICacheAdapter;
import com.kuoji.abstractfactorypattern.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 * 集群使用服务
 */
public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    public String get(String key) {
        return egm.gain(key);
    }

    public void set(String key, String value) {
        egm.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        egm.delete(key);
    }

}
