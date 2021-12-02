package com.kuoji.factorypattern.service.impl;

import com.kuoji.factorypattern.service.ICommodity;

/**
 * 商店工厂
 */
public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityServiceImpl();
        if (2 == commodityType) return new GoodsCommodityServiceImpl();
        if (3 == commodityType) return new CardCommodityServiceImpl();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
