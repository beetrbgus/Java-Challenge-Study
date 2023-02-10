package com.beetrb.secondweek.repository;

import com.beetrb.secondweek.persistence.Coupon;

import java.util.List;
import java.util.Optional;

public interface CouponCustomRepository {
    Optional<Coupon> getCouponByKoreanOrSymbol(String name);
}
