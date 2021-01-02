package com.geek.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * HTTP 请求返回的最外层对象。
 *
 * @author geek
 */
@Data
public class ResultVO<T> implements Serializable {

    private Integer code;// 错误码。
    private String msg;// 提示信息。
    //    private String msg = "";// 提示信息。默认返回 "" 空字符串，否则返回 null。
    private T data;// 返回具体内容。

}

/*
There was an unexpected error (type=Internal Server Error, status=500).
No converter found for return value of type: class com.geek.VO.ResultVO
 */
