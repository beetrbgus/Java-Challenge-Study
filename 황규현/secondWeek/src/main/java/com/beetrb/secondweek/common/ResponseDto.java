package com.beetrb.secondweek.common;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto<T> {
    private T data;

    @Builder
    public ResponseDto(T data) {
        this.data = data;
    }

}
