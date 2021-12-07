package com.kuoji.prototypepattern.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Topic {

    private Map<String, String> option;  // 选项；A、B、C、D
    private String key;           // 答案；B
}
