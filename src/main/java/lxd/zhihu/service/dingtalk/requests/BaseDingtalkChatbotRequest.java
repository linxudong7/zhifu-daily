/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseDingtalkChatbotRequest
 * Author:   rubby
 * Date:     2019/2/19 16:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.dingtalk.requests;


/**
 * 钉钉机器人统一请求值
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
public class BaseDingtalkChatbotRequest {

    /**
     * 消息类型:文本（text）、连接（link）、markdown（markdown）...
     */
    private String msgType;
    /**
     * 机器人地址
     */
    private String webhook;
    /**
     * 时间间隔
     */
    private Long interval;
    /**
     * 知乎消息类型
     */
    private String zhihuMsgType;

    private String requestId;

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public String getZhihuMsgType() {
        return zhihuMsgType;
    }

    public void setZhihuMsgType(String zhihuMsgType) {
        this.zhihuMsgType = zhihuMsgType;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
