package lxd.zhihu.enums;

public enum ZhihuMsgType {
    /**
     * 最新消息
     */
    LstestNews("latestNews"),
    /**
     * 老消息
     */
    OldNews("oldNews"),
    /**
     * 热门消息
     */
    HotNews("hotNews");

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
