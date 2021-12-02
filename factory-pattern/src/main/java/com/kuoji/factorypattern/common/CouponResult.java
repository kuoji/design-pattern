package com.kuoji.factorypattern.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CouponResult {
    private String code; // 编码
    private String info; // 描述
}
