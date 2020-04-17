package com.geek.controller;

import com.geek.VO.ResultVO;
import com.geek.converter.OrderForm2OrderDTOConverter;
import com.geek.dto.OrderDTO;
import com.geek.enums.ResultEnum;
import com.geek.exception.SellException;
import com.geek.form.OrderForm;
import com.geek.service.BuyerService;
import com.geek.service.OrderDetailService;
import com.geek.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private BuyerService buyerService;

    // 创建订单。
    /*
    name:张三
phone:12345678901
address:武汉
openid:lyfGeek
items:[{productId: "123457", productQuantity: 2}]
     */
    // 192.168.0.108:8080/sell/buyer/order/create
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确。orderForm = {}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空。");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderDetailService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);

    }

    // 订单列表。
    // 192.168.0.108:8080/sell/buyer/order/list?openid=lyfGeek&page&size
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid 为空。");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest pageRequest = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderDetailService.findList(openid, pageRequest);

        // Date ——> Long。
        // 低效。

        return ResultVOUtil.success(orderDTOPage.getContent());
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        return resultVO;
    }

    // 订单详情。
    // 192.168.0.108:8080/sell/buyer/order/detail?openid=lyfGeek&orderId=1587108908282657149
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        // 不安全。改进。
//        OrderDTO orderDTO = orderDetailService.findOne(orderId);
//        orderDetailService.cancel(orderDTO);
        // 改进。
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    // 取消订单。
    // 192.168.0.108:8080/sell/buyer/order/cancel
    @PostMapping("cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        // 不安全。
//        OrderDTO orderDTO = orderDetailService.findOne(orderId);
//        orderDetailService.cancel(orderDTO);

        // 不安全。改进。
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
    }
}
