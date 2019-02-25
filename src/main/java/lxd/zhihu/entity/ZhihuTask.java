/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZhihuTask
 * Author:   rubby
 * Date:     2019/2/25 10:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.entity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/25
 * @since 1.0.0
 */
public class ZhihuTask {
    /**
     * task1.cronExpression = /10 * * * * ?
     * task1.msgType = markdown
     * task1.zhihuMsgType = latestNews
     * task1.group = group1
     * task1.atMobiles = 13073673633
     * task1.oldNews.date = 20180101
     * task1.listOldNews.startDate = 20180101
     * task1.listOldNews.endDate = 20181111
     */
    private String cronExpression;
    private String msgType;
    private String zhihuMsgType;
    private List<String> groupsName;
    private List<String> atMobiles;
    private String oldNewsDate;
    private String listOldNewsStartDate;
    private String listOldNewsEndDate;

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getZhihuMsgType() {
        return zhihuMsgType;
    }

    public void setZhihuMsgType(String zhihuMsgType) {
        this.zhihuMsgType = zhihuMsgType;
    }

    public List<String> getGroupsName() {
        return groupsName;
    }

    public void setGroupsName(List<String> groupsName) {
        this.groupsName = groupsName;
    }

    public List<String> getAtMobiles() {
        return atMobiles;
    }

    public void setAtMobiles(List<String> atMobiles) {
        this.atMobiles = atMobiles;
    }

    public String getOldNewsDate() {
        return oldNewsDate;
    }

    public void setOldNewsDate(String oldNewsDate) {
        this.oldNewsDate = oldNewsDate;
    }

    public String getListOldNewsStartDate() {
        return listOldNewsStartDate;
    }

    public void setListOldNewsStartDate(String listOldNewsStartDate) {
        this.listOldNewsStartDate = listOldNewsStartDate;
    }

    public String getListOldNewsEndDate() {
        return listOldNewsEndDate;
    }

    public void setListOldNewsEndDate(String listOldNewsEndDate) {
        this.listOldNewsEndDate = listOldNewsEndDate;
    }
}
