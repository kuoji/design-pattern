package com.kuoji.adapterpattern.service.impl;

import com.kuoji.adapterpattern.service.OrderAdapterService;
import com.kuoji.adapterpattern.service.POPOrderService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
