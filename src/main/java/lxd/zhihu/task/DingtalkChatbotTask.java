/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DingtalkTask
 * Author:   rubby
 * Date:     2019/2/19 16:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lxd.zhihu.task;

import lxd.zhihu.entity.LatestNewsEntity;
import lxd.zhihu.entity.StoryEntity;
import lxd.zhihu.enums.ZhihuMsgType;
import lxd.zhihu.service.dingtalk.DingtalkChatbotClient;
import lxd.zhihu.exception.RRException;
import lxd.zhihu.service.ZhihuNewsService;
import lxd.zhihu.service.dingtalk.message.MarkdownMessage;
import lxd.zhihu.service.dingtalk.message.ZhihuLatestNewsTemplate;
import lxd.zhihu.service.dingtalk.requests.BaseDingtalkChatbotRequest;
import lxd.zhihu.service.dingtalk.requests.DingtalkMarkdownRequest;
import lxd.zhihu.service.zhihu.requests.QueryLatestNewsRequest;
import lxd.zhihu.service.zhihu.responses.LatestNewsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
@Component
public class DingtalkChatbotTask {

    private static final Logger logger = LoggerFactory.getLogger(DingtalkChatbotTask.class);

    @Autowired
    private DingtalkChatbotClient dingtalkChatbotClient;

    @Autowired
    private ZhihuNewsService zhihuNewsService;

    public void sendLatestNewsMarkdownMessage(DingtalkMarkdownRequest request) {
        if (! ZhihuMsgType.LstestNews.getType().equals(request.getZhihuMsgType())) {
            throw new RRException("知乎消息类型有误");
        }
        LatestNewsResponse latestNewsResponse = zhihuNewsService.queryLatestNews(new QueryLatestNewsRequest());
        if (!latestNewsResponse.isSuccess()) {
            throw new RRException("知乎服务获取每日最新消息失败");
        }
        LatestNewsEntity latestNewsEntity = latestNewsResponse.getLatestNewsEntity();

        //构建MarkdownMessage信息
        MarkdownMessage markdownMessage = ZhihuLatestNewsTemplate.getMarkdownType(request, latestNewsEntity);

        try {
            dingtalkChatbotClient.send(request.getWebhook(), markdownMessage);
            logger.debug("%s------发送markdown类型知乎最新消息成功",request.getRequestId());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

    }
}
