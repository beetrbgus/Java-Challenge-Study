package com.beetrb.secondweek.repository;

import static com.beetrb.secondweek.persistence.QCoupon.coupon;

import com.beetrb.secondweek.persistence.Coupon;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
@RequiredArgsConstructor
public class CouponCustomRepositoryImpl implements CouponCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Coupon> getCouponByKoreanOrSymbol(String name) {
        return Optional.ofNullable(
                queryFactory
                    .selectFrom(coupon)
                    .where(coupon.name.like("%"+ name +"%"))
                    .fetchFirst()
        );
    }
}
