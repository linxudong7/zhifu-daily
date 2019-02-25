/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HotNewsEntity
 * Author:   rubby
 * Date:     2019/2/21 11:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.entity;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/21
 * @since 1.0.0
 */
public class HotNewsEntity {
    private List<HotNewEntity> recent;

    public List<HotNewEntity> getRecent() {
        return recent;
    }

    public void setRecent(List<HotNewEntity> recent) {
        this.recent = recent;
    }

    public String toJsonString() {
        Map<String, Object> hotNewsEntity = new HashMap<>();
        hotNewsEntity.put("recent", recent);
        return JSON.toJSONString(hotNewsEntity);
    }
}
