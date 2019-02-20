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

import lxd.zhihu.entity.LatestNewsEntity;
import lxd.zhihu.entity.MessageInfo;
import lxd.zhihu.service.DingtalkService;
import lxd.zhihu.service.ZhihuNewsService;
import lxd.zhihu.service.zhihu.requests.QueryLatestNewsRequest;
import lxd.zhihu.service.zhihu.responses.LatestNewsResponse;
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
    private ZhihuNewsService zhihuNewsService;

    @Autowired
    private DingtalkService dingtalkService;

    @Test
    public void dingtalkTest() {
        List<String> atMobiles = new ArrayList<String>();
        atMobiles.add("13073673633");
        dingtalkService.sendMessage(new MessageInfo("markdown","https://oapi.dingtalk.com/robot/send?access_token=38846b13c359d2f2ac9985df73133c9ef9694353bf640b9f08ae771e352c8bd7",atMobiles,"car",3600L));

    }

}
