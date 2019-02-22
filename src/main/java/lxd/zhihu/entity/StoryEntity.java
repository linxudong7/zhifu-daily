/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StoryEntity
 * Author:   rubby
 * Date:     2019/2/19 11:01
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
 * 新闻
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
public class StoryEntity {
    @JSONField(ordinal = 0)
    private List<String> images;
    @JSONField(ordinal = 1)
    private Integer type;
    @JSONField(ordinal = 2)
    private Integer id;
    @JSONField(ordinal = 3,name = "ga_prefix")
    private String gaPrefix;
    @JSONField(ordinal = 4)
    private String title;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGaPrefix() {
        return gaPrefix;
    }

    public void setGaPrefix(String gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toJsonString() {
        Map<String, Object> story = new HashMap<>();
        story.put("images", images);
        story.put("type", type);
        story.put("id", id);
        story.put("ga_prefix", gaPrefix);
        story.put("title", title);

        return JSON.toJSONString(story);
    }

}
