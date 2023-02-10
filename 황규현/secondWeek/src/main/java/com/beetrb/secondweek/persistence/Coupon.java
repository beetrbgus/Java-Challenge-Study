package com.beetrb.secondweek.persistence;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "coupon")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String name;
    private String code;
    private Long discountValue;
    @Enumerated(EnumType.STRING)
    private CouponStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiredAt;

    @Builder
    public Coupon(Long id, Long userId,String name, String code, Long discountValue, CouponStatus status) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.code = code;
        this.discountValue = discountValue;
        this.status = status;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    public void expiredCoupon() {
        this.status = CouponStatus.EXPIRED;
    }
}
