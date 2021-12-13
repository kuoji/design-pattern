package com.kuoji.adapterpattern;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * MQ消息体适配类
 * 主要用于把不同类型MQ中的各种属性，映射成我们需要的属性并返回。 就像一个属性中有用户ID;uId，映射到我们需要的；userId，做统一处理
 * 而在这个处理过程中需要把映射管理传递给Map<String, String> link，也就是准确的描述了，当前MQ中某个属性名称，映射为我们的某个属性名称
 * 最终接收到的mq消息基本都是json格式，可以转换为MAP结构。最后使用反射调用的方式给我们的类型赋值
 */
public class MQAdapter {

    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }

    /**
     *  obj为需要转换的数据  number:0001
     *  link为映射属性  userId:number  将number字段映射为userId
     *
     */
    public static RebateInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {
            // obj的value
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class)
                                .invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }
}
