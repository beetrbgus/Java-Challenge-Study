package com.beetrb.secondweek.repository;

import com.beetrb.secondweek.persistence.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long>, CouponCustomRepository {

}
