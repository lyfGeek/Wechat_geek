package com.geek.repository;

import com.geek.dataObject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private IOrderDetailRepository repository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567891");
        orderDetail.setOrderId("111111");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("1111111");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductQuantity(2);

        OrderDetail save = repository.save(orderDetail);
        Assert.assertNotNull(save);
        System.out.println("save = " + save);

    }

    @Test
    public void testFindByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("111111");
        Assert.assertNotEquals(0, orderDetailList.size());
        System.out.println("orderDetailList = " + orderDetailList);
    }
}
