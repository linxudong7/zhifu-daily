package lxd.zhihu.enums;

public enum ZhihuMsgType {
    /**
     * 每日最新消息
     */
    LATEST_NEWS("latestNews"),
    /**
     * 过往消息
     */
    OLD_NEWS("oldNews"),
    /**
     * 热门消息
     */
    HOT_NEWS("hotNews");

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    ZhihuMsgType(String type) {
        this.type = type;
    }
}
