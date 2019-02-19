/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MessageInfo
 * Author:   rubby
 * Date:     2019/2/19 16:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lxd.educ.entity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
public class MessageInfo {
    /**
     * 信息发送类型
     */
    private String msgType;
    /**
     * 机器人地址
     */
    private String webhock;
    /**
     * 电话号码
     */
    private List<String> atMobiles;
    /**
     * 查阅类型
     */
    private String type;
    /**
     * 时间间隔
     */
    private Long interval;

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getWebhock() {
        return webhock;
    }

    public void setWebhock(String webhock) {
        this.webhock = webhock;
    }

    public List<String> getAtMobiles() {
        return atMobiles;
    }

    public void setAtMobiles(List<String> atMobiles) {
        this.atMobiles = atMobiles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public MessageInfo(String msgType, String webhock, List<String> atMobiles, String type, Long interval) {
        this.msgType = msgType;
        this.webhock = webhock;
        this.atMobiles = atMobiles;
        this.type = type;
        this.interval = interval;
    }
}
