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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lxd.zhihu.entity.HotNewEntity;
import lxd.zhihu.entity.MessageInfo;
import lxd.zhihu.entity.LatestNewsEntity;
import lxd.zhihu.entity.OldNewsEntity;
import lxd.zhihu.service.DingtalkService;
import lxd.zhihu.service.ZhihuNewsService;
import lxd.zhihu.service.zhihu.requests.QueryHotNewsRequest;
import lxd.zhihu.service.zhihu.requests.QueryLatestNewsRequest;
import lxd.zhihu.service.zhihu.requests.QueryOldNewsRequest;
import lxd.zhihu.service.zhihu.responses.HotNewsResponse;
import lxd.zhihu.service.zhihu.responses.LatestNewsResponse;
import lxd.zhihu.service.zhihu.responses.OldNewsResponse;
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
public class ZhihuServiceTest {

    @Autowired
    private ZhihuNewsService zhihuNewsService;

    @Test
    public void queryLatestNewsTest() {
        QueryLatestNewsRequest queryLatestNewsRequest = new QueryLatestNewsRequest("https://news-at.zhihu.com/api/4/news/latest","get");
        LatestNewsResponse latestNewsResponse = zhihuNewsService.queryLasestNews(queryLatestNewsRequest);
        LatestNewsEntity latestNewsEntity = latestNewsResponse.getLatestNewsEntity();
        System.out.println(latestNewsEntity.toJsonString());
    }

    @Test
    public void queryOldNewsTest() {
        QueryOldNewsRequest queryOldNewsRequest = new QueryOldNewsRequest("https://news-at.zhihu.com/api/4/news/before", "get", "20190220");
        OldNewsResponse oldNewsResponse = zhihuNewsService.queryOldNewsByDate(queryOldNewsRequest);
        OldNewsEntity oldNewsEntity = oldNewsResponse.getOldNewsEntity();
        System.out.println(oldNewsEntity.toJsonString());
    }

    @Test
    public void queryHotNewsTest() {
        QueryHotNewsRequest queryHotNewsRequest = new QueryHotNewsRequest("https://news-at.zhihu.com/api/3/news/hot", "get");
        HotNewsResponse hotNewsResponse = zhihuNewsService.queryHotNews(queryHotNewsRequest);
        List<HotNewEntity> hotNewEntities = hotNewsResponse.getHotNewEntities();
        System.out.println(hotNewEntities.get(0).toJsonString());
    }
}
