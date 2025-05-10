package com.example.loginexample._core.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Resp<T> {
    private Integer status;
    private String msg;
    private T body;

    private Resp() {
    }

    public static <B> Resp<?> ok(B body) {
        return new Resp<>(200, "성공", body);
    }

    public static Resp<?> fail(Integer status, String msg) {
        return new Resp<>(status, msg, null);
    }
}
