package com.kuoji.bridgepattern;

import com.kuoji.bridgepattern.channel.Pay;
import com.kuoji.bridgepattern.channel.WxPay;
import com.kuoji.bridgepattern.channel.ZfbPay;
import com.kuoji.bridgepattern.mode.PayFaceMode;
import com.kuoji.bridgepattern.mode.PayFingerprintMode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class BridgePatternApplicationTests {

    @Test
    public void test_pay() {
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));
    }

}
