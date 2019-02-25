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

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lxd.zhihu.entity.MarkdownNew;
import lxd.zhihu.entity.StoryEntity;
import lxd.zhihu.enums.DingtalkGroups;
import lxd.zhihu.exception.BizException;
import lxd.zhihu.service.ZhihuNewsService;
import lxd.zhihu.service.dingtalk.DingtalkChatbotClient;
import lxd.zhihu.service.dingtalk.message.MarkdownMessage;
import lxd.zhihu.service.zhihu.requests.QueryLatestNewsRequest;
import lxd.zhihu.service.zhihu.responses.LatestNewsResponse;
import lxd.zhihu.utils.IllegalException;
import lxd.zhihu.utils.JinJavaUtil;
import lxd.zhihu.utils.MobileUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
@Component("dingtalkChatbotTask")
public class DingtalkChatbotTask {

    private static final Logger logger = LoggerFactory.getLogger(DingtalkChatbotTask.class);

    @Autowired
    private DingtalkChatbotClient dingtalkChatbotClient;

    @Autowired
    private ZhihuNewsService zhihuNewsService;

    public void sendLatestNewsMarkdownMessage() {
        Properties properties = new Properties();
        InputStream inStream = DingtalkChatbotTask.class.getClassLoader().getResourceAsStream("task.properties");
        try {
            properties.load(inStream);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        QueryLatestNewsRequest queryLatestNewsRequest = new QueryLatestNewsRequest();
        LatestNewsResponse latestNewsResponse = zhihuNewsService.queryLatestNews(queryLatestNewsRequest);
        if (!latestNewsResponse.isSuccess()) {
            throw new BizException("知乎服务获取每日最新消息失败");
        }
        MarkdownMessage markdownMessage = getMarkdownMessage(properties, latestNewsResponse);

        String groupsNameStr = properties.getProperty("task1.groupsName");
        if (Strings.isNullOrEmpty(groupsNameStr)) {
            throw new IllegalException("缺少钉钉群名");
        }
        HashMap<String, String> groupsMap = DingtalkGroups.getDingtalkGroupsMap();
        String[] arrayGroupsNameStr = StringUtils.split(groupsNameStr,",");
        for (String groupNameStr: arrayGroupsNameStr
             ) {
            if (groupsMap.containsKey(groupNameStr)) {
                try {
                    dingtalkChatbotClient.send(groupsMap.get(groupNameStr), markdownMessage);
                    logger.debug(String.format("%s------发送markdown类型知乎最新消息成功", queryLatestNewsRequest.getRequestId()));
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }

    }

    private MarkdownMessage getMarkdownMessage(Properties properties, LatestNewsResponse latestNewsResponse) {
        MarkdownMessage markdownMessage = new MarkdownMessage();
        HashMap<String, Object> context = Maps.newHashMap();
        String atMobilesStr = properties.getProperty("task1.atMobiles");
        if (Strings.isNullOrEmpty(atMobilesStr)) {
            markdownMessage.setAtAll(true);
        }else {
            List<String> atMobiles = MobileUtil.getMobilesStr(atMobilesStr);
            markdownMessage.setAtMobiles(atMobiles);
            context.put("atMobiles", atMobiles);
        }
        ArrayList<MarkdownNew> markdownNews = Lists.newArrayList();
        List<StoryEntity> storyEntities = latestNewsResponse.getLatestNewsEntity().getStories();
        markdownMessage.setTitle(storyEntities.get(0).getTitle());
        for (StoryEntity storyEntity: storyEntities
        ) {
            MarkdownNew markdownNew = new MarkdownNew();
            BeanUtils.copyProperties(storyEntity, markdownNew);
            markdownNew.setImage(storyEntity.getImages().get(0));
            markdownNews.add(markdownNew);
        }
        context.put("markdownNews", markdownNews);
        String markdownText = JinJavaUtil.toMardownText(context, "zhihu.md");
        markdownMessage.setText(markdownText);
        return markdownMessage;
    }

}
