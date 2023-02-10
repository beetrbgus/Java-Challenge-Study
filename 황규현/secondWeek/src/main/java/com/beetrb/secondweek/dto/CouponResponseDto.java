package com.beetrb.secondweek.dto;

import com.beetrb.secondweek.persistence.Coupon;
import com.beetrb.secondweek.persistence.CouponStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CouponResponseDto {
    private Long id;
    private Long userId;
    private String name;
    private String code;
    private Long discountValue;
    private CouponStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiredAt;

    public CouponResponseDto(Coupon coupon) {
        this.id = coupon.getId();
        this.userId = coupon.getUserId();
        this.name = coupon.getName();
        this.code = coupon.getCode();
        this.discountValue = coupon.getDiscountValue();
        this.status = coupon.getStatus();
        this.createdAt = coupon.getCreatedAt();
        this.updatedAt = coupon.getUpdatedAt();
        this.expiredAt = coupon.getExpiredAt();
    }
}
