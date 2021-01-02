package com.geek.service;

import com.geek.dto.OrderDTO;

/**
 * 买家。
 *
 * @author geek
 */
public interface IBuyerService {

    /**
     * 查询一个订单。
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单。
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);

}
