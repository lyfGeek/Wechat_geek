package com.geek.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）。
 *
 * @author geek
 */
@Data
public class ProductVO implements Serializable {

    @JsonProperty("name")// 返回给前端为 name。
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
