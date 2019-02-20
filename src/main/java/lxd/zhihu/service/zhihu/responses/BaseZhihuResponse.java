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
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/20
 * @since 1.0.0
 */
public class BaseZhihuResponse {

    private boolean isSuccess;

    private String msg;

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
        items.put("isSuccess", isSuccess);
        return JSON.toJSONString(items);
    }
}
