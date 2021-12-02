package com.kuoji.factorypattern.service.impl;

import com.alibaba.fastjson.JSON;
import com.kuoji.factorypattern.common.CouponResult;
import com.kuoji.factorypattern.service.ICommodity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 优惠券
 */
@Slf4j
public class CouponCommodityServiceImpl implements ICommodity {
    private Logger logger = LoggerFactory.getLogger(CouponCommodityServiceImpl.class);

    // 模拟注入
    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId,commodityId,bizId);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }
}
