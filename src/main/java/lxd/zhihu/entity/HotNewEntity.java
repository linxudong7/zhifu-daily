/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HotNewEntity
 * Author:   rubby
 * Date:     2019/2/20 18:23
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
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/20
 * @since 1.0.0
 */
public class HotNewEntity {
    @JSONField(ordinal = 0, name = "news_id")
    private Long newsId;
    @JSONField(ordinal = 1)
    private String url;
    @JSONField(ordinal = 2)
    private String thumbnail;
    @JSONField(ordinal = 3)
    private String title;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toJsonString() {
        Map<String, Object> hotNewEntity = new HashMap<>();
        hotNewEntity.put("news_id", newsId);
        hotNewEntity.put("url", url);
        hotNewEntity.put("thumbnail", thumbnail);
        hotNewEntity.put("title", title);
        return JSON.toJSONString(hotNewEntity);
    }
}
