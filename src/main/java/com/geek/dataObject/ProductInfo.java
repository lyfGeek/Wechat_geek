package com.geek.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo implements Serializable {

    @Id
    private String productId;
    // 名称。
    private String productName;
    // 单价。
    private BigDecimal productPrice;
    // 库存。
    private Integer productStock;
    // 描述。
    private String productDescription;
    // 小图。
    private String productIcon;
    // 状态。0 正常，1 下架。
    private Integer productStatus;
    // 类目编号。
    private Integer categoryType;
//    private Date createTime;
//    private Date updateTime;

}
