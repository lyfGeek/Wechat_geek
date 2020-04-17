package com.geek.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
public class OrderDetail implements Serializable {

    @Id
    private String detailId;

    private String orderId;// 订单 id，

    private String productId;// 商品 id。

    private String productName;// 商品名称。

    private BigDecimal productPrice;// 单价。

    private Integer productQuantity;// 商品数量。

    private String productIcon;// 商品小图。
}
