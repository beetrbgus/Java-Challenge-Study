package com.beetrb.secondweek;

import com.beetrb.secondweek.persistence.Coupon;
import com.beetrb.secondweek.persistence.CouponStatus;
import com.beetrb.secondweek.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CouponTest {
    @Autowired
    CouponService couponService;
    @Test
    void createCoupon() {

      for (int i = 0; i < 100; i++) {
          Coupon coupon =
                Coupon
                    .builder()
                    .code("c00"+i)
                    .name("쿠폰"+i)
                    .status(CouponStatus.NORMAL)
                    .userId(10000L+i)
                    .discountValue(i+0L)
                    .build();
          Coupon coupon1 = couponService.createCoupon(coupon);
          System.out.println(coupon1.getId());
          System.out.println(coupon1.getCode());
          System.out.println(coupon1.getName());
          System.out.println(coupon1.getStatus());
          System.out.println(coupon1.getUserId());
          System.out.println(coupon1.getDiscountValue());

      }
    }
}
