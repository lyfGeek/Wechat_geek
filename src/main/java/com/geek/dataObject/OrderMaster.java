package com.geek.dataObject;

import com.geek.enums.OrderStatusEnum;
import com.geek.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderMaster implements Serializable {

    @Id
    private String orderId;// 订单 id。
    private String buyerName;// 买家名字。
    private String buyerPhone;// 买家电话。
    private String buyerOpenid;// 买家微信 openId。
    private BigDecimal orderAmount;// 订单总金额。BigDecimal。
    private String buyerAddress;

    // 订单状态。默认为 0，新下单。
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    // 支付状态。默认为 0，未支付。
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;// 创建时间。

    private Date updateTime;// 修改时间。

//    @Transient
//    private List<OrderDetail> orderDetailList;

}
