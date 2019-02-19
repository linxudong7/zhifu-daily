/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZhifuDaily
 * Author:   rubby
 * Date:     2019/2/19 14:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lxd.educ.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
public class ZhifuDaily implements Serializable {
    private String date;
    private List<Story> stories;
    @JsonProperty("top_stories")
    private List<TopStory> topStories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<TopStory> getTopStories() {
        return topStories;
    }

    public void setTopStories(List<TopStory> topStories) {
        this.topStories = topStories;
    }

    @Override
    public String toString() {
        return "ZhifuDaily{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + topStories +
                '}';
    }
}
