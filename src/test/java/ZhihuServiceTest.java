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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lxd.zhihu.entity.HotNewsEntity;
import lxd.zhihu.entity.LatestNewsEntity;
import lxd.zhihu.entity.OldNewsEntity;
import lxd.zhihu.entity.StoryEntity;
import lxd.zhihu.service.ZhihuNewsService;
import lxd.zhihu.service.dingtalk.message.MarkdownMessage;
import lxd.zhihu.service.zhihu.requests.QueryHotNewsRequest;
import lxd.zhihu.service.zhihu.requests.QueryLatestNewsRequest;
import lxd.zhihu.service.zhihu.requests.QueryOldNewsRequest;
import lxd.zhihu.service.zhihu.responses.HotNewsResponse;
import lxd.zhihu.service.zhihu.responses.LatestNewsResponse;
import lxd.zhihu.service.zhihu.responses.OldNewsResponse;
import lxd.zhihu.utils.JinJavaUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
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
public class ZhihuServiceTest {

    @Autowired
    private ZhihuNewsService zhihuNewsService;

    @Test
    public void queryLatestNewsTest() {
        QueryLatestNewsRequest queryLatestNewsRequest = new QueryLatestNewsRequest();
        LatestNewsResponse latestNewsResponse = zhihuNewsService.queryLatestNews(queryLatestNewsRequest);
        LatestNewsEntity latestNewsEntity = latestNewsResponse.getLatestNewsEntity();
        System.out.println(latestNewsEntity.toJsonString());
    }

    @Test
    public void queryOldNewsTest() {
        QueryOldNewsRequest queryOldNewsRequest = new QueryOldNewsRequest("20190102");
        OldNewsResponse oldNewsResponse = zhihuNewsService.queryOldNewsByDate(queryOldNewsRequest);
        OldNewsEntity oldNewsEntity = oldNewsResponse.getOldNewsEntity();
        System.out.println(oldNewsEntity.toJsonString());
    }

    @Test
    public void ListOldNewsTest() {
        List<OldNewsResponse> oldNewsResponses = zhihuNewsService.listOldNewsByDateRange("20180102","20180202");
        for (OldNewsResponse response: oldNewsResponses
             ) {
            OldNewsEntity oldNewsEntity = response.getOldNewsEntity();
            System.out.println(oldNewsEntity.toJsonString());
        }
    }
    @Test
    public void queryHotNewsTest() {
        QueryHotNewsRequest queryHotNewsRequest = new QueryHotNewsRequest();
        HotNewsResponse hotNewsResponse = zhihuNewsService.queryHotNews(queryHotNewsRequest);
        System.out.println(hotNewsResponse.toString());
        HotNewsEntity hotNewsEntity = hotNewsResponse.getHotNewsEntity();
        System.out.println(hotNewsEntity.toJsonString());
    }

    @Test
    public void markdownTest() {

        QueryLatestNewsRequest queryLatestNewsRequest = new QueryLatestNewsRequest();
        LatestNewsResponse latestNewsResponse = zhihuNewsService.queryLatestNews(queryLatestNewsRequest);

        MarkdownMessage markdownMessage = new MarkdownMessage();

        List<StoryEntity> stories = latestNewsResponse.getLatestNewsEntity().getStories();
        markdownMessage.setTitle(stories.get(0).getTitle());

        HashMap<String, Object> context = Maps.newHashMap();
        context.put("stories", stories);
        ArrayList<String> atMobiles = Lists.newArrayList();
        atMobiles.add("13073673633");
        context.put("atMobiles", atMobiles);
        markdownMessage.setAtMobiles(atMobiles);

        String mardownText = JinJavaUtil.toMardownText(context, "zhihu.md");
        markdownMessage.setText(mardownText);
        System.out.println(markdownMessage.toJsonString());
    }

}
