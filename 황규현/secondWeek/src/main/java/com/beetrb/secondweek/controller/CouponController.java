package com.beetrb.secondweek.controller;

import com.beetrb.secondweek.common.ResponseDto;
import com.beetrb.secondweek.dto.CouponRequestDto;
import com.beetrb.secondweek.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupon")
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<ResponseDto> useCoupon(@RequestBody CouponRequestDto requestDto) {
        if(requestDto.getCouponName() == null
            || !StringUtils.hasText(requestDto.getCouponName())) {

            HttpHeaders resHeaders = new HttpHeaders();
            resHeaders.add("Content-Type", "application/json;charset=UTF-8");
            return ResponseEntity
                    .status(400)
                    .headers(resHeaders)
                    .body(
                        ResponseDto
                            .builder()
                            .data("쿠폰 이름이 올바르지 않습니다.")
                            .build()
                    );
        }

        return ResponseEntity.ok(
                ResponseDto
                    .builder()
                    .data(couponService.getCouponByKoreanAndSymbol(
                            requestDto.getCouponName())
                    )
                    .build()
        );
    }
}
