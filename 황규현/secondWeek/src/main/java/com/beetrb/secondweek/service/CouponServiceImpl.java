package com.beetrb.secondweek.service;

import com.beetrb.secondweek.common.ResponseDto;
import com.beetrb.secondweek.dto.CouponResponseDto;
import com.beetrb.secondweek.persistence.Coupon;
import com.beetrb.secondweek.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{
    private final CouponRepository couponRepository;

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public ResponseDto getCouponByKoreanAndSymbol(String name) {
        Coupon coupon = couponRepository.getCouponByKoreanOrSymbol(name)
                .orElseThrow();
        if(LocalDateTime.now().isBefore(coupon.getCreatedAt())
            || LocalDateTime.now().isAfter(coupon.getExpiredAt())) {
            coupon.expiredCoupon();
            couponRepository.save(coupon);
            return ResponseDto.builder()
                    .data("만료된 쿠폰입니다.").build();
        }
        return ResponseDto.builder()
                .data(coupon).build();
    }
}
