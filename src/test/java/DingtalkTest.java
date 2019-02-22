/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ZhihuServiceTest
 * Author:   rubby
 * Date:     2019/2/19 13:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import lxd.zhihu.enums.ZhihuMsgType;
import lxd.zhihu.service.ZhihuNewsService;
import lxd.zhihu.service.dingtalk.WebhookConfig;
import lxd.zhihu.service.dingtalk.requests.DingtalkMarkdownRequest;
import lxd.zhihu.task.DingtalkChatbotTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class DingtalkTest {

    @Autowired
    private DingtalkChatbotTask dingtalkChatbotTask;

    @Test
    public void dingtalkTest() {
        List<String> atMobiles =  new ArrayList<>();
        atMobiles.add("13073673633");
        DingtalkMarkdownRequest request = new DingtalkMarkdownRequest("markdown", WebhookConfig.CHATBOT_WEBHOOK, atMobiles, 3600L, ZhihuMsgType.LstestNews.getType());
        dingtalkChatbotTask.sendLatestNewsMarkdownMessage(request);
    }

}
