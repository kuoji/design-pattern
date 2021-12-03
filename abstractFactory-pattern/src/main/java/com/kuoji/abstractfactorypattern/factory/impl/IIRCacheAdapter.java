package com.kuoji.abstractfactorypattern.factory.impl;

import com.kuoji.abstractfactorypattern.factory.ICacheAdapter;
import com.kuoji.abstractfactorypattern.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * 集群使用服务
 */
public class IIRCacheAdapter implements ICacheAdapter {

    private IIR iir = new IIR();

    public String get(String key) {
        return iir.get(key);
    }

    public void set(String key, String value) {
        iir.set(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        iir.del(key);
    }

}
