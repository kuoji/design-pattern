package com.kuoji.factorypattern.service;

import java.util.Map;

public interface ICommodity {

    /**
     * 发奖接口
     * @param uId 用户ID
     * @param commodityId 奖品ID
     * @param bizId  业务ID
     * @param extMap 扩展字段 用于处理发放实物商品时的收获地址
     * @throws Exception
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
