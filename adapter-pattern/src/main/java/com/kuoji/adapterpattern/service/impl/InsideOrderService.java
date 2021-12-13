package com.kuoji.adapterpattern.service.impl;

import com.kuoji.adapterpattern.service.OrderAdapterService;
import com.kuoji.adapterpattern.service.OrderService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
