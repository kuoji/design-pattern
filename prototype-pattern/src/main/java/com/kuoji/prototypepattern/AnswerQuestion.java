package com.kuoji.prototypepattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 解答题
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswerQuestion {

    private String name;  // 问题
    private String key;   // 答案

}
