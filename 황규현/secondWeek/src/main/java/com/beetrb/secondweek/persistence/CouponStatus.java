package com.beetrb.secondweek.persistence;

public enum CouponStatus {
    NORMAL("사용가능"),
    EXPIRED("만료된"),
    DELETED("삭제된");
    
    private String messgae;
    CouponStatus(String message) {
        this.messgae = message;
    }
}
