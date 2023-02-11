package com.beetrb.secondweek.service;

import com.beetrb.secondweek.dto.CouponResponseDto;
import com.beetrb.secondweek.persistence.Coupon;

public interface CouponService {
    Coupon createCoupon(Coupon coupon);
    CouponResponseDto getCouponByKoreanAndSymbol(String name);
}
