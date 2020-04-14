package com.geek.repository;

import com.geek.dataObject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void testFindOne() {
        ProductCategory category = repository.findOne(1);
        System.out.println("category = " + category);
    }

    @Test
    @Transactional// import javax.transaction.Transactional;
    // 测试完回滚。
    public void testSave() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        System.out.println("result = " + result);
    }

    @Test
    public void testUpdate() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(3);
        ProductCategory category = repository.save(productCategory);
        System.out.println("category = " + category);

        // 这样 update_time 不会更新。
        // category = ProductCategory(categoryId=2, categoryName=男生最爱, categoryType=3, create_time=null, update_time=null)

        // @DynamicUpdate
        // 动态更新。
    }

    @Test
    public void testFindByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(0, result.size());
        System.out.println("result = " + result);
    }

}
