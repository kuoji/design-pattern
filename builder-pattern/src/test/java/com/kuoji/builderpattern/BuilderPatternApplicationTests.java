package com.kuoji.builderpattern;

import com.kuoji.builderpattern.service.impl.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.DelayQueue;

@SpringBootTest
class BuilderPatternApplicationTests {

    @Test
    public void test_Builder(){
        Builder builder = new Builder();
        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());
        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());
        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());

    }

}
