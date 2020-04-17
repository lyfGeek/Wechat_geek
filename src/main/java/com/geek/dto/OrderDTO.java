package com.geek.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.geek.dataObject.OrderDetail;
import com.geek.utils.seriallizer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)// deprecated.
//@JsonInclude(JsonInclude.Include.NON_NULL)// "orderDetailList": null
// 全局配置。——> application.yml
//   jackson:
//    default-property-inclusion: non_null
@Data
public class OrderDTO implements Serializable {

    @Id
    private String orderId;// 订单 id。
    private String buyerName;// 买家名字。
    private String buyerPhone;// 买家电话。
    private String buyerOpenid;// 买家微信 openId。
    private BigDecimal orderAmount;// 订单总金额。BigDecimal。
    private String buyerAddress;

    // 订单状态。默认为 0，新下单。
    private Integer orderStatus;

    // 支付状态。默认为 0，未支付。
    private Integer payStatus;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;// 创建时间。

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;// 修改时间。
    // "createTime": 1586386394,
//    "createTime": 1586386394000,

    //    private List<OrderDetail> orderDetailList = new ArrayList<>();
    // 默认值。如果为空，给前端返回 []。
    private List<OrderDetail> orderDetailList;// 否则返回 null。

}

/*
 {
            "orderId": "1587108908282657149",
            "buyerName": "张三",
            "buyerPhone": "12345678901",
            "buyerOpenid": "lyfGeek",
            "orderAmount": 6.40,
            "buyerAddress": "武汉",
            "orderStatus": 0,
            "payStatus": 0,
            "createTime": 1586385466,
            "updateTime": 1586385466,
            "orderDetailList": null
        },
 */
