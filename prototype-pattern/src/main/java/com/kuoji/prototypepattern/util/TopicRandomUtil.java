package com.kuoji.prototypepattern.util;

import java.util.*;

public class TopicRandomUtil {

    /**
     * 乱序Map元素，记录对应答案key
     * @param option 选项
     * @param key    答案
     * @return Topic 乱序后 {A=c., B=d., C=a., D=b.}
     */
    static public Topic random(Map<String, String> option, String key) {
        // option的key值
        Set<String> keySet = option.keySet();
        // 乱序后的key值
        ArrayList<String> keyList = new ArrayList<String>(keySet);
        Collections.shuffle(keyList);
        // 存储新的选项
        HashMap<String, String> optionNew = new HashMap<String, String>();
        int idx = 0;
        String keyNew = "";
        for (String next : keySet) {
            String randomKey = keyList.get(idx++);
            // 保存乱序后的答案key
            if (key.equals(next)) {
                keyNew = randomKey;
            }
            optionNew.put(randomKey, option.get(next));
        }
        return new Topic(optionNew, keyNew);
    }

}
