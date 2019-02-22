/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DingtalkMarkdownRequest
 * Author:   rubby
 * Date:     2019/2/22 17:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.service.dingtalk.requests;

import java.util.List;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/22
 * @since 1.0.0
 */
public class DingtalkMarkdownRequest extends BaseDingtalkChatbotRequest {
    private List<String> atMobiles;

    public List<String> getAtMobiles() {
        return atMobiles;
    }

    public void setAtMobiles(List<String> atMobiles) {
        this.atMobiles = atMobiles;
    }

    public DingtalkMarkdownRequest(String msgType, String webhook, List<String> atMobiles, Long interval, String zhihuMsgType) {
        this.setMsgType("markdown");
        this.setWebhook(webhook);
        this.setInterval(interval);
        this.setZhihuMsgType(zhihuMsgType);
        this.atMobiles = atMobiles;
        this.setRequestId(UUID.randomUUID().toString().replaceAll("-", ""));
    }
}
