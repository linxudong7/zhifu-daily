/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseZhihuResponse
 * Author:   rubby
 * Date:     2019/2/20 10:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.zhihu.responses;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 知乎统一返回值
 *
 * @author rubby
 * @create 2019/2/20
 * @since 1.0.0
 */
public class BaseZhihuResponse<T>{

    private boolean isSuccess;

    private java.lang.String msg;

    private Integer code;

    private java.lang.String requestId;

    private String data;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public java.lang.String getMsg() {
        return msg;
    }

    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public java.lang.String getRequestId() {
        return requestId;
    }

    public void setRequestId(java.lang.String requestId) {
        this.requestId = requestId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public java.lang.String toString(){
        Map<java.lang.String, Object> items = new HashMap<java.lang.String, Object>();
        items.put("msg", msg);
        items.put("data", data);
        items.put("code", code);
        items.put("requestId", requestId);
        items.put("isSuccess", isSuccess);
        return JSON.toJSONString(items);
    }
}
