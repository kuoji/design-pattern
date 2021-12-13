package com.koji.adapterpattern;

import com.alibaba.fastjson.JSON;
import com.kuoji.adapterpattern.MQAdapter;
import com.kuoji.adapterpattern.RebateInfo;
import com.kuoji.adapterpattern.mq.OrderMq;
import com.kuoji.adapterpattern.mq.create_account;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = AdapterPatternApplicationTests.class)
class AdapterPatternApplicationTests {

    @Test
    void testJsonMap(){

       create_account create_account = new create_account();
       create_account.setNumber("100001");
       create_account.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
       create_account.setAccountDate(new Date());
       create_account.setDesc("在校开户");

       String strJson = create_account.toString();
       Map map = JSON.parseObject(strJson, Map.class);


       System.out.println("strJson is : " + strJson);
       System.out.println("map is : " + map);
    }


    @Test
     void contextLoads() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        create_account create_account = new create_account();
        create_account.setNumber("100001");
        create_account.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
        create_account.setAccountDate(new Date());
        create_account.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(create_account.toString(), link01);
        System.out.println("mq.create_account(适配前)" + create_account.toString());
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo01));

        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(new Date());

        HashMap<String, String> link02 = new HashMap<String, String>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);

        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));
    }

}
