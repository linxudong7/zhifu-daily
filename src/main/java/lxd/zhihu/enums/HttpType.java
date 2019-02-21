package lxd.zhihu.enums;

public enum HttpType {
    /**
     * get请求
     */
    GET("get"),
    /**
     * post请求
     */
    POST("post");
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    HttpType(String httpType) {
        this.type = httpType;
    }
}
