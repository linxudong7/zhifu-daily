/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Story
 * Author:   rubby
 * Date:     2019/2/19 11:01
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
 * 新闻
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
public class Story implements Serializable {
    private List<String> images;
    private Integer type;
    private Integer id;
    @JsonProperty("ga_prefix")
    private String gaPrefix;
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

    @Override
    public String toString() {
        return "Story{" +
                "images=" + images +
                ", type=" + type +
                ", id=" + id +
                ", ga_prefix='" + gaPrefix + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
