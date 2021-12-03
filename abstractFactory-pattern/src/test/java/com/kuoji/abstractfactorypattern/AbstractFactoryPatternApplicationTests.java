package com.kuoji.abstractfactorypattern;

import com.kuoji.abstractfactorypattern.factory.JDKProxy;
import com.kuoji.abstractfactorypattern.factory.impl.EGMCacheAdapter;
import com.kuoji.abstractfactorypattern.factory.impl.IIRCacheAdapter;
import com.kuoji.abstractfactorypattern.service.CacheService;
import com.kuoji.abstractfactorypattern.service.impl.CacheServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AbstractFactoryPatternApplicationTests {

    @Test
    public void test_CacheService() throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01","小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println(val01);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01","小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println(val02);
    }

}
