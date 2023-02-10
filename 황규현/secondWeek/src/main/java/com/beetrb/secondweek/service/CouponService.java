package com.beetrb.secondweek.service;

import com.beetrb.secondweek.common.ResponseDto;
import com.beetrb.secondweek.dto.CouponResponseDto;
import com.beetrb.secondweek.persistence.Coupon;

import java.util.List;

public interface CouponService {
    Coupon createCoupon(Coupon coupon);
    ResponseDto getCouponByKoreanAndSymbol(String name);
}
