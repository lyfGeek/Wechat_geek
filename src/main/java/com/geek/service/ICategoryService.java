package com.geek.service;

import com.geek.dataObject.ProductCategory;

import java.util.List;

/**
 * @author geek
 */
public interface ICategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
