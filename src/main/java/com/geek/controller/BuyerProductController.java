package com.geek.controller;

import com.geek.VO.ProductInfoVO;
import com.geek.VO.ProductVO;
import com.geek.VO.ResultVO;
import com.geek.dataObject.ProductCategory;
import com.geek.dataObject.ProductInfo;
import com.geek.service.CategoryService;
import com.geek.service.ProductInfoService;
import com.geek.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        // 查询所有上架商品。
        List<ProductInfo> upAll = productInfoService.findUpAll();

        // 查询类目（一次性查询）。
        // 传统方法。
        /*List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : upAll) {
            Integer categoryType = productInfo.getCategoryType();
            categoryTypeList.add(categoryType);
        }*/
        // 精简。（Java 8 lambda）。
        List<Integer> categoryTypeList = upAll.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 数据拼装。
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : upAll) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);// 拷贝数据。
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);

/*
        ResultVO resultVO = new ResultVO();

        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVo = new ProductInfoVO();

        productVO.setProductInfoVOList(Arrays.asList(productInfoVo));
        resultVO.setData(Arrays.asList(productVO));
*/
/*        resultVO.setData(productVOList);
        resultVO.setCode(0);
        resultVO.setMsg("成功。");

        return resultVO;*/
    }


}
