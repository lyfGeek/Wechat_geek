package com.geek.enums;

import lombok.Getter;

/**
 * @author geek
 */
@Getter
public enum OrderStatusEnum {

    NEW(0, "新订单。"),
    FINISHED(1, "订单完结。"),
    CANCEL(2, "订单已取消。");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
