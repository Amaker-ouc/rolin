package com.rolin.utils;

import java.util.List;
import java.util.Map;

public class DataResponse {
//    0：成功
//    100：请求错误
//    101：缺少appKey
//    102：缺少签名
//    103：缺少参数
//    200：服务器出错
//    201：服务不可用
//    202：服务器正在重启
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
