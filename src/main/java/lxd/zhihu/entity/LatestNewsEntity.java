/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LatestNewsEntity
 * Author:   rubby
 * Date:     2019/2/19 14:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.dingtalk.chatbot.message.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
public class LatestNewsEntity {
    @JSONField(ordinal = 0)
    private String date;
    @JSONField(ordinal = 1)
    private List<StoryEntity> stories;
    @JSONField(ordinal = 2,name = "top_stories")
    private List<TopStoryEntity> topStories;

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

    public List<TopStoryEntity> getTopStories() {
        return topStories;
    }

    public void setTopStories(List<TopStoryEntity> topStories) {
        this.topStories = topStories;
    }

    public String toJsonString() {
        Map<String, Object> latestNewsEntity = new HashMap<>();
        latestNewsEntity.put("date", date);
        latestNewsEntity.put("stories", stories);
        latestNewsEntity.put("top_stories", topStories);
        return JSON.toJSONString(latestNewsEntity);
    }

}
