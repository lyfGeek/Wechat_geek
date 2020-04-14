package com.geek.service.impl;

import com.geek.dataObject.ProductInfo;
import com.geek.enums.ProductStatusEnum;
import com.geek.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
        System.out.println("productInfo = " + productInfo);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0, productInfoList.size());
        System.out.println("productInfoList = " + productInfoList);
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(pageRequest);
        long totalElements = productInfoPage.getTotalElements();
        Assert.assertNotEquals(0, totalElements);
        System.out.println("totalElements = " + totalElements);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的虾");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(ProductStatusEnum.DOWN.getCode());
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
        System.out.println("result = " + result);
    }
}
