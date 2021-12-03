package com.kuoji.abstractfactorypattern.factory;

import java.util.concurrent.TimeUnit;

/**
 * 定义适配接口
 * 主要作用 : 让所有集群的提供方，能在统一的方法名称下进行操作。也方面后续的拓展
 */
public interface ICacheAdapter {
    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
