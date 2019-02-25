/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: OldNewsEntity
 * Author:   rubby
 * Date:     2019/2/20 17:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/20
 * @since 1.0.0
 */
public class OldNewsEntity {
    /**
     * 需要查询11月18日的消息，应为 20131119
     */
    @JSONField(ordinal = 0)
    private String date;
    @JSONField(ordinal = 1)
    private List<StoryEntity> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoryEntity> getStories() {
        return stories;
    }

    public void setStories(List<StoryEntity> stories) {
        this.stories = stories;
    }

    public String toJsonString() {
        Map<String, Object> latestNewsEntity = new HashMap<>();
        latestNewsEntity.put("date", date);
        latestNewsEntity.put("stories", stories);
        return JSON.toJSONString(latestNewsEntity);
    }
}
